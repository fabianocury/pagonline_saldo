package br.com.pagonline.saldo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@EnableBinding(Sink.class)
public class EfetivaListener {

    @Autowired
    private EfetivaService efetivaService;


    public EfetivaListener(EfetivaService efetivaService) {
        this.efetivaService = efetivaService;
    }

    @StreamListener(Sink.INPUT)
    void handle(EfetivaTransacaoEvent efetivaTransacaoEvent) {
        efetivaService.efetiva(efetivaTransacaoEvent);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EfetivaTransacaoEvent {

        private String idClienteCredito;
        private String idClienteDebito;
        private BigDecimal valor;

        @Override
        public String toString() {
            return "EfetivaTransacaoEvent{" +
                    "idClienteCredito='" + idClienteCredito + '\'' +
                    ", idClienteDebito='" + idClienteDebito + '\'' +
                    ", valor=" + valor +
                    '}';
        }

        public String getIdClienteCredito() {
            return idClienteCredito;
        }

        public void setIdClienteCredito(String idClienteCredito) {
            this.idClienteCredito = idClienteCredito;
        }

        public String getIdClienteDebito() {
            return idClienteDebito;
        }

        public void setIdClienteDebito(String idClienteDebito) {
            this.idClienteDebito = idClienteDebito;
        }

        public BigDecimal getValor() {
            return valor;
        }

        public void setValor(BigDecimal valor) {
            this.valor = valor;
        }
    }
}
