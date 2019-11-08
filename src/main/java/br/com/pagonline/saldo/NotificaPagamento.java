package br.com.pagonline.saldo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "notifica")
public interface NotificaPagamento {



}
