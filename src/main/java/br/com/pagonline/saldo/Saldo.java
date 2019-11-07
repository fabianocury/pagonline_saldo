package br.com.pagonline.saldo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Saldo {

    @Id
    private Long id_cliente;

    @Column(nullable=false)
    private BigDecimal saldo_efetivo;

    @Column(nullable=false)
    private BigDecimal saldo_congelado;

    public Saldo(Long id_cliente, BigDecimal saldo_efetivo, BigDecimal saldo_congelado) {
        this.id_cliente = id_cliente;
        this.saldo_efetivo = saldo_efetivo;
        this.saldo_congelado = saldo_congelado;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public BigDecimal getSaldo_efetivo() {
        return saldo_efetivo;
    }

    public void setSaldo_efetivo(BigDecimal saldo_efetivo) {
        this.saldo_efetivo = saldo_efetivo;
    }

    public BigDecimal getSaldo_congelado() {
        return saldo_congelado;
    }

    public void setSaldo_congelado(BigDecimal saldo_congelado) {
        this.saldo_congelado = saldo_congelado;
    }
}
