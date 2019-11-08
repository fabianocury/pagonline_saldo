package br.com.pagonline.saldo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EfetivaService {

    @Autowired
    private SaldoRepository saldoRepository;

    @Autowired
    private NotificaPagamento notificaPagamento;

    @Autowired
    private ClientesPagamento clientesPagamento;

    @Autowired
    private RestTemplateConfig restTemplateConfig;

    public void efetiva(EfetivaListener.EfetivaTransacaoEvent event) {
        System.out.println("event = " + event);

        // Cliente Debito
        Long idClienteDebito = Long.valueOf(event.getIdClienteDebito());
        Saldo saldoDebito = saldoRepository.findById(idClienteDebito).orElse(null);
        Long idClienteCredito = Long.valueOf(event.getIdClienteCredito());
        Saldo saldoCredito = saldoRepository.findById(idClienteCredito).orElse(null);

        if (saldoDebito == null) {
            saldoRepository.save(new Saldo(idClienteDebito, event.getValor().multiply(new BigDecimal(-1)) ,BigDecimal.ZERO));
        } else {
            saldoRepository.save(new Saldo(idClienteDebito, saldoDebito.getSaldo_efetivo().subtract(event.getValor()) ,saldoDebito.getSaldo_congelado()));

        }

        if (saldoCredito == null) {
            saldoRepository.save(new Saldo(idClienteCredito, event.getValor() ,BigDecimal.ZERO));
        } else {
            saldoRepository.save(new Saldo(idClienteCredito, saldoCredito.getSaldo_efetivo().add(event.getValor()) ,saldoCredito.getSaldo_congelado()));
        }

        Cliente clienteCredito = clientesPagamento.getCliente(idClienteCredito);
        Cliente clienteDebito = clientesPagamento.getCliente(idClienteDebito);

        System.out.println("clienteCredito = " + clienteCredito);
        System.out.println("clienteDebito = " + clienteDebito);


        RestTemplateBuilder restTemplateBuilder = restTemplateConfig.restTemplateBuilder();
        List<Object> respostaCredito = restTemplateBuilder.build().getForObject(clienteCredito.getUrl().get(0), List.class);
        List<Object> respostaDebito = restTemplateBuilder.build().getForObject(clienteDebito.getUrl().get(0), List.class);


//        notificaPagamento
    }

}
