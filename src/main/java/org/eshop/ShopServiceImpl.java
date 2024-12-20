package org.eshop;

class ShopServiceImpl implements ShopService {

    @Override
    public void processOrderWithUserInput() {
        ConsoleHelper.showMessage("Welcome to the online store!");

        // 1. Gather customer information
        String customerName = gatherCustomerInformation();

        // 2. Create the order using the Builder pattern
        Builder<Order> builder = new OrderBuilder();
        builder.setCustomerName(customerName);

        // 3. Add products to the cart
        addProductsToCart(builder);

        // 4. Select a delivery method
        DeliveryStrategy deliveryStrategy = selectDeliveryMethod(builder);

        // 5. Choose a payment method
        choosePaymentMethod(builder);

        // 6. Build the order
        Order order = builder.build();

        // 7. Process the order
        processOrder(order);

        // 8. Execute the delivery strategy
        executeDeliveryStrategy(order, deliveryStrategy);

        // 9. Process the order using Chain of Responsibility
        handleOrderWithChain(order);
    }

    private String gatherCustomerInformation() {
        return ConsoleHelper.askString("Enter your full name:");
    }

    private void addProductsToCart(Builder<Order> builder) {
        boolean addingProducts = true;
        while (addingProducts) {
            String product = ConsoleHelper.askString("Add a product to the cart (enter name):");
            builder.addProduct(product);

            String more = ConsoleHelper.askString("Do you want to add another product? (yes/no):");
            addingProducts = more.equalsIgnoreCase("yes") || more.equalsIgnoreCase("y");
        }
    }

    private DeliveryStrategy selectDeliveryMethod(Builder<Order> builder) {
        ConsoleHelper.showMessage("Available Delivery methods:");
        ConsoleHelper.showMessage("1. Courier");
        ConsoleHelper.showMessage("2. In-store Pickup");
        ConsoleHelper.showMessage("3. Parcel locker Courier");

        int deliveryChoice = ConsoleHelper.askInt("Choose a delivery method (1-3):");

        DeliveryStrategy deliveryStrategy;
        String deliveryMethod;

        switch (deliveryChoice) {
            case 1 -> {
                deliveryMethod = "Courier";
                deliveryStrategy = new CourierDelivery();
            }
            case 2 -> {
                deliveryMethod = "In-store Pickup";
                deliveryStrategy = new InStorePickup();
            }
            case 3 -> {
                deliveryMethod = "Parcel locker Courier";
                deliveryStrategy = new ParcelLockerDelivery();
            }
            default -> throw new IllegalArgumentException("Invalid delivery method choice.");
        }

        builder.setDeliveryMethod(deliveryMethod);
        return deliveryStrategy;
    }

    private void choosePaymentMethod(Builder<Order> builder) {
        String paymentMethod = ConsoleHelper.askString("Enter payment method (e.g., card, cash):");
        builder.setPaymentMethod(paymentMethod);
    }

    private void executeDeliveryStrategy(Order order, DeliveryStrategy deliveryStrategy) {
        DeliveryContext deliveryContext = new DeliveryContext(deliveryStrategy);
        deliveryContext.executeStrategy(order);
    }

    private void handleOrderWithChain(Order order) {
        OrderHandler validationHandler = new ValidationHandler();
        OrderHandler paymentHandler = new PaymentHandler();

        validationHandler.setNextHandler(paymentHandler);
        paymentHandler.setNextHandler(new DeliveryHandler());

        ConsoleHelper.showMessage("Starting order processing:");
        validationHandler.handle(order);
    }

    private void processOrder(Order order) {
        System.out.println("Processing order for: " + order.getCustomerName());
        System.out.println("Products: " + order.getProducts());
        System.out.println("Delivery: " + order.getDeliveryMethod());
        System.out.println("Payment: " + order.getPaymentMethod());
    }
}
