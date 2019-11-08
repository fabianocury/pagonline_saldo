package br.com.pagonline.saldo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ClientesFallBack implements ClientesPagamento{

    @Override
    public Cliente getCliente(Long id) {
        return new Cliente("5", "Santander", new ArrayList<String>(){{add("Tchumbers");}}, "IdErrado");
    }
}
