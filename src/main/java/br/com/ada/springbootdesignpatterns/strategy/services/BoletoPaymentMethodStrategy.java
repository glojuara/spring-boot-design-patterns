package br.com.ada.springbootdesignpatterns.strategy.services;

import br.com.ada.springbootdesignpatterns.strategy.PaymentMethodStrategy;
import org.springframework.stereotype.Service;

@Service("BOLETO")
public class BoletoPaymentMethodStrategy implements PaymentMethodStrategy {

    @Override
    public String pay() {
        return "PAGO COM BOLETO";
    }

}
