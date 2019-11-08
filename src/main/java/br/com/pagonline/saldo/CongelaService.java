package br.com.pagonline.saldo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CongelaService {

    @Autowired
    private SaldoRepository saldoRepository;

    public void efetiva(CongelaListener.CongelaTransacaoEvent event) {
        System.out.println("event = " + event);

        // Cliente Debito
        Saldo saldo = saldoRepository.findById(Long.valueOf(event.getIdClienteDebito())).orElse(null);

        if (saldo == null) {
            saldoRepository.save(new Saldo(Long.valueOf(event.getIdClienteDebito()), BigDecimal.ZERO, event.getValor()));
        } else {
            saldoRepository.save(new Saldo(Long.valueOf(event.getIdClienteDebito()), saldo.getSaldo_efetivo() ,saldo.getSaldo_congelado().add(event.getValor())));

        }
    }

}
