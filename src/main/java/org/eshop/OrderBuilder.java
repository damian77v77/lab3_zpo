package org.eshop;

import java.util.ArrayList;
import java.util.List;

class OrderBuilder implements Builder<Order> {
    private String customerName;
    private List<String> products = new ArrayList<>();
    private String deliveryMethod;
    private String paymentMethod;

    @Override
    public OrderBuilder setCustomerName(String name) {
        this.customerName = name;
        return this;
    }

    @Override
    public OrderBuilder addProduct(String product) {
        this.products.add(product);
        return this;
    }

    @Override
    public OrderBuilder setDeliveryMethod(String method) {
        this.deliveryMethod = method;
        return this;
    }

    @Override
    public OrderBuilder setPaymentMethod(String method) {
        this.paymentMethod = method;
        return this;
    }

    @Override
    public Order build() {
        return new Order(customerName, products, deliveryMethod, paymentMethod);
    }
}