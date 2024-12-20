package org.eshop;

class ParcelLockerDelivery implements DeliveryStrategy {
    @Override
    public void deliver(Order order) {
        System.out.println("Delivery by parcel locker courier. Estimated delivery time: 1 day.");
    }
}
