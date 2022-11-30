package br.com.ada.springbootdesignpatterns.strategy.controllers.v1;

import br.com.ada.springbootdesignpatterns.strategy.services.BoletoPaymentMethodStrategy;
import br.com.ada.springbootdesignpatterns.strategy.services.CreditCardPaymentMethodStrategy;
import br.com.ada.springbootdesignpatterns.strategy.services.PayPalPaymentMethodStrategy;
import br.com.ada.springbootdesignpatterns.strategy.PaymentMethodStrategy;

public enum PaymentMethod {

    BOLETO(BoletoPaymentMethodStrategy.class),
    CREDIT_CARD(CreditCardPaymentMethodStrategy.class),
    PAY_PALL(PayPalPaymentMethodStrategy.class);

    private Class<? extends PaymentMethodStrategy> paymentMethodClass;

    PaymentMethod(Class<? extends PaymentMethodStrategy> paymentMethodClass) {
        this.paymentMethodClass = paymentMethodClass;
    }

    public Class<? extends PaymentMethodStrategy> getPaymentMethodClass() {
        return paymentMethodClass;
    }
}
