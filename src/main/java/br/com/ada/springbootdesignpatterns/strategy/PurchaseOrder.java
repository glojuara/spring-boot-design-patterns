package br.com.ada.springbootdesignpatterns.strategy;

public class PurchaseOrder {

    private final PaymentMethodStrategy paymentMethodStrategy;

    public PurchaseOrder(PaymentMethodStrategy paymentMethodStrategy) {
        this.paymentMethodStrategy = paymentMethodStrategy;
    }

    public String pay() {
        return paymentMethodStrategy.pay();
    }

}
