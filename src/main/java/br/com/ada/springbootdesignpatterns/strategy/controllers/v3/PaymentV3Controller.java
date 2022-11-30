package br.com.ada.springbootdesignpatterns.strategy.controllers.v3;

import br.com.ada.springbootdesignpatterns.strategy.services.PaymentMethodStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/payments")
public class PaymentV3Controller {
    private final ApplicationContext context;

    public PaymentV3Controller(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("pay/{paymentMethod}")
    public String pay(@PathVariable String paymentMethod) {
        PaymentMethodStrategy paymentMethodStrategy = (PaymentMethodStrategy) context.getBean(paymentMethod);
        return paymentMethodStrategy.pay();
    }

}
