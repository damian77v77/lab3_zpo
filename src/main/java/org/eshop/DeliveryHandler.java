package org.eshop;

class DeliveryHandler extends OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("Order prepared for Delivery via: " + order.getDeliveryMethod());
    }
}