package org.eshop;

interface Builder<T> {
    Builder<T> setCustomerName(String name);
    Builder<T> addProduct(String product);
    Builder<T> setDeliveryMethod(String method);
    Builder<T> setPaymentMethod(String method);
    T build();
}