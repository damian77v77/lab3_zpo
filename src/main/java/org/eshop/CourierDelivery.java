package org.eshop;

class CourierDelivery implements DeliveryStrategy {
    @Override
    public void deliver(Order order) {
        System.out.println("Delivery by courier. Estimated delivery time: 2 days.");
    }
}