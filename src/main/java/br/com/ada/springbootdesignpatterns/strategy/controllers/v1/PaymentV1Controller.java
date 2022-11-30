package br.com.ada.springbootdesignpatterns.strategy.controllers.v1;

import br.com.ada.springbootdesignpatterns.strategy.PaymentMethodStrategy;
import br.com.ada.springbootdesignpatterns.strategy.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/payments")
public class PaymentV1Controller {

    @Autowired
    private List<PaymentMethodStrategy> paymentMethodStrategies;

    @GetMapping("pay/{paymentMethod}")
    public String pay(@PathVariable String paymentMethod) {

        PaymentMethodStrategy paymentMethodStrategy = paymentMethodStrategies.stream()
                .filter(it -> it.getClass().equals(PaymentMethod.valueOf(paymentMethod).getPaymentMethodClass()))
                .findFirst().orElseThrow(() -> new RuntimeException("MÉTODO DE PAGAMENTO NÃO ENCONTRADO"));

        PurchaseOrder purchaseOrder = new PurchaseOrder(paymentMethodStrategy);
        return purchaseOrder.pay();
    }

}
