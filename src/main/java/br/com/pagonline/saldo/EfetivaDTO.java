package br.com.pagonline.saldo;

import java.math.BigDecimal;
import java.util.Optional;

public class EfetivaDTO {


    private Optional<Long> id;
    private Optional<Long> idClienteCredito;
    private Optional<Long> idClienteDebito;
    private Optional<BigDecimal> valor;


    public Optional<Long> getId() {
        return id;
    }

    public void setId(Optional<Long> id) {
        this.id = id;
    }

    public Optional<BigDecimal> getValor() {
        return valor;
    }

    public void setValor(Optional<BigDecimal> valor) {
        this.valor = valor;
    }

    public Optional<Long> getIdClienteCredito() {
        return idClienteCredito;
    }

    public void setIdClienteCredito(Optional<Long> idClienteCredito) {
        this.idClienteCredito = idClienteCredito;
    }

    public Optional<Long> getIdClienteDebito() {
        return idClienteDebito;
    }

    public void setIdClienteDebito(Optional<Long> idClienteDebito) {
        this.idClienteDebito = idClienteDebito;
    }
}
