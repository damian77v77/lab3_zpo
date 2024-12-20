package org.eshop;

class ValidationHandler extends OrderHandler {
    @Override
    public void handle(Order order) {
        if (order.getCustomerName() == null || order.getProducts().isEmpty()) {
            throw new IllegalArgumentException("Order validation failed!");
        }
        System.out.println("Order validated.");
        if (nextHandler != null) nextHandler.handle(order);
    }
}