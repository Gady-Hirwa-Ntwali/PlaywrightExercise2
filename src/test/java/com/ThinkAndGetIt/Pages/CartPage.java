package com.ThinkAndGetIt.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CartPage {
    private final Page page;
    private final Locator closeCart;
    private final Locator checkoutBtn;



    public CartPage(Page page){
        this.page = page;
        this.closeCart = page.locator(".flex.items-center.justify-between > .btn-icon");
        this.checkoutBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Checkout"));
    }

    public CheckoutPage clickCheckoutBtn(){
        checkoutBtn.click();
        return new CheckoutPage(page);
    }
}
