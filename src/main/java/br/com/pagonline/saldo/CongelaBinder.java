package br.com.pagonline.saldo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface CongelaBinder {

    String CONGELA = "congela";

    @Input(CONGELA)
    MessageChannel channel();
}
