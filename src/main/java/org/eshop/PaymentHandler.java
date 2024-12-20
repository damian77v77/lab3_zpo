package org.eshop;

class PaymentHandler extends OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("Payment processed for method: " + order.getPaymentMethod());
        if (nextHandler != null) nextHandler.handle(order);
    }
}

