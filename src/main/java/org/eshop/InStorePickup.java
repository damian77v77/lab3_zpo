package org.eshop;

class InStorePickup implements DeliveryStrategy {
    @Override
    public void deliver(Order order) {
        System.out.println("Order ready for in-store pickup.");
    }
}