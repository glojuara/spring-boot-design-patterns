package br.com.ada.springbootdesignpatterns.strategy.controllers.v2;

import br.com.ada.springbootdesignpatterns.strategy.PaymentMethodStrategy;
import br.com.ada.springbootdesignpatterns.strategy.PurchaseOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("v2/payments")
public class PaymentV2Controller {

    private final Map<String, PaymentMethodStrategy> paymentMethodStrategyMap;

    public PaymentV2Controller(Map<String, PaymentMethodStrategy> paymentMethodStrategyMap) {
        this.paymentMethodStrategyMap = paymentMethodStrategyMap;
    }

    @GetMapping("pay/{paymentMethod}")
    public String pay(@PathVariable String paymentMethod) {
        PaymentMethodStrategy paymentMethodStrategy = paymentMethodStrategyMap.get(paymentMethod);

        PurchaseOrder purchaseOrder = new PurchaseOrder(paymentMethodStrategy);
        return purchaseOrder.pay();
    }

}
