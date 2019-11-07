package br.com.pagonline.saldo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EfetivaService {

    @Autowired
    private SaldoRepository saldoRepository;

    public void efetiva(EfetivaListener.EfetivaTransacaoEvent event) {
        System.out.println("event = " + event);

        // Cliente Debito
        Saldo saldo = saldoRepository.findById(Long.valueOf(event.getIdClienteDebito())).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        System.out.println("saldo.getId_cliente() = " + saldo.getId_cliente());
        //saldoRepository.save();

        //Cliente Credito

        //saldoRepository.save()
    }

}
