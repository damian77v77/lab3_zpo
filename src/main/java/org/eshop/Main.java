package org.eshop;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopServiceImpl();
        ShopFacade shopFacade = new ShopFacade(shopService);
        shopFacade.processOrderWithUserInput();
    }

}