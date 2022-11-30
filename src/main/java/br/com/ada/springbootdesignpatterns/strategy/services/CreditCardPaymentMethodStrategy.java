package br.com.ada.springbootdesignpatterns.strategy.services;

import br.com.ada.springbootdesignpatterns.strategy.PaymentMethodStrategy;
import org.springframework.stereotype.Service;

@Service("CREDIT_CARD")
public class CreditCardPaymentMethodStrategy implements PaymentMethodStrategy {

    @Override
    public String pay() {
        return "PAGO COM CARTÃO DE CRÉDITO";
    }

}
