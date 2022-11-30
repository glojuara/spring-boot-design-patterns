package br.com.ada.springbootdesignpatterns.strategy.controllers.v3;

import br.com.ada.springbootdesignpatterns.strategy.PaymentMethodStrategy;
import br.com.ada.springbootdesignpatterns.strategy.PurchaseOrder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v3/payments")
public class PaymentV3Controller {
    private final ApplicationContext context;

    public PaymentV3Controller(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("pay/{paymentMethod}")
    public String pay(@PathVariable String paymentMethod) {
        PaymentMethodStrategy paymentMethodStrategy = (PaymentMethodStrategy) context.getBean(paymentMethod);
        PurchaseOrder purchaseOrder = new PurchaseOrder(paymentMethodStrategy);
        return purchaseOrder.pay();
    }

}
