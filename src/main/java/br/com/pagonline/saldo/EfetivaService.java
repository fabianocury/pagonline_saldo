package br.com.pagonline.saldo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EfetivaService {

    @Autowired
    private SaldoRepository saldoRepository;

    public void efetiva(EfetivaListener.EfetivaTransacaoEvent event) {
        System.out.println("event = " + event);

        // Cliente Debito
        Saldo saldoDebito = saldoRepository.findById(Long.valueOf(event.getIdClienteDebito())).orElse(null);
        Saldo saldoCredito = saldoRepository.findById(Long.valueOf(event.getIdClienteCredito())).orElse(null);

        if (saldoDebito == null) {
            saldoRepository.save(new Saldo(Long.valueOf(event.getIdClienteDebito()), event.getValor().multiply(new BigDecimal(-1)) ,BigDecimal.ZERO));
        } else {
            saldoRepository.save(new Saldo(Long.valueOf(event.getIdClienteDebito()), saldoDebito.getSaldo_efetivo().subtract(event.getValor()) ,BigDecimal.ZERO));

        }

        if (saldoCredito == null) {
            saldoRepository.save(new Saldo(Long.valueOf(event.getIdClienteCredito()), event.getValor() ,BigDecimal.ZERO));
        } else {
            saldoRepository.save(new Saldo(Long.valueOf(event.getIdClienteCredito()), saldoDebito.getSaldo_efetivo().add(event.getValor()) ,BigDecimal.ZERO));
        }

        //System.out.println("saldo.getId_cliente() = " + saldo.getId_cliente());
        //saldoRepository.save();

        //Cliente Credito

        //saldoRepository.save()
    }

}
