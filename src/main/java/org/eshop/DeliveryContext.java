package org.eshop;

class DeliveryContext {
    private final DeliveryStrategy strategy;

    public DeliveryContext(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Order order) {
        strategy.deliver(order);
    }
}