package br.com.pagonline.saldo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@EnableBinding(CongelaBinder.class)
public class CongelaListener{

    @Autowired
    private CongelaService congelaService;

    public CongelaListener(CongelaService efetivaService) {
        this.congelaService = efetivaService;
    }

    @StreamListener(CongelaBinder.CONGELA)
    void handle(CongelaTransacaoEvent congelaTransacaoEvent) {
        congelaService.efetiva(congelaTransacaoEvent);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CongelaTransacaoEvent {

        private String idClienteDebito;
        private BigDecimal valor;

        @Override
        public String toString() {
            return "CongelaTransacaoEvent{" +
                    "idClienteDebito='" + idClienteDebito + '\'' +
                    ", valor=" + valor +
                    '}';
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
