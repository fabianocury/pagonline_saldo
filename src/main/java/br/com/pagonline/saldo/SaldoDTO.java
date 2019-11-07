package br.com.pagonline.saldo;

import java.math.BigDecimal;
import java.util.Optional;

public class SaldoDTO {


    private Optional<Long> idCliente;
    private Optional<BigDecimal> valor;


    public Optional<Long> getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Optional<Long> idCliente) {
        this.idCliente = idCliente;
    }

    public Optional<BigDecimal> getValor() {
        return valor;
    }

    public void setValor(Optional<BigDecimal> valor) {
        this.valor = valor;
    }

}
