package br.com.pagonline.saldo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/solicitaDeposito")
public class SaldoController {

    @Autowired
    private SaldoRepository saldoRepository;

    @PostMapping
    ResponseEntity solicitaDeposito(@RequestBody SaldoDTO saldoDto) {
        Saldo saldo = new Saldo(saldoDto.getIdCliente().get(),saldoDto.getValor().get(), BigDecimal.ZERO );
        saldoRepository.save(saldo);
        return new ResponseEntity(HttpStatus.OK);
    }

}
