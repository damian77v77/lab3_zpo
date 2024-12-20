package org.eshop;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShopFacade {

    private final ShopService shopService;

    public void processOrderWithUserInput() {
        shopService.processOrderWithUserInput();
    }
}
