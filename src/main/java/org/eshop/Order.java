package org.eshop;

import lombok.AllArgsConstructor;
import lombok.Value;
import java.util.List;

@Value
@AllArgsConstructor
class Order {
    String customerName;
    List<String> products;
    String deliveryMethod;
    String paymentMethod;
}
