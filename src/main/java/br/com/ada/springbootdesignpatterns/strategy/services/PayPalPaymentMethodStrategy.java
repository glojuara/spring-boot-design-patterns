package br.com.ada.springbootdesignpatterns.strategy.services;

import org.springframework.stereotype.Service;

@Service("PAY_PALL")
public class PayPalPaymentMethodStrategy implements PaymentMethodStrategy {

    @Override
    public String pay() {
        return "PAGO COM PAY PALL";
    }

}
