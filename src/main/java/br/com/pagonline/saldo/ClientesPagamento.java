package br.com.pagonline.saldo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "clientes")
public interface ClientesPagamento {

    @GetMapping("/clientes/{id}")
    Cliente getCliente(@PathVariable("id") Long id);


}
