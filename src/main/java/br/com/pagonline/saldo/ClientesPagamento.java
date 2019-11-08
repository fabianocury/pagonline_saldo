package br.com.pagonline.saldo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "clientes", fallback = ClientesFallBack.class)
public interface ClientesPagamento {

    @GetMapping("/clientes/{id}")
    Cliente getCliente(@PathVariable("id") Long id);


}
