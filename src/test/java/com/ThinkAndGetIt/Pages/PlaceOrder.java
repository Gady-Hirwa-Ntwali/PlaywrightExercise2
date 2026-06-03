package com.ThinkAndGetIt.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PlaceOrder {
    private final Page page;
    private final Locator changeAddress;
    private final Locator changePayment;
    private final Locator backBtn;
    private final Locator placeOrder;
    public PlaceOrder(Page page){
        this.page = page;
        this.changeAddress = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Change")).first();
        this.changePayment = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Change")).nth(1);
        this.backBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back"));
        this.placeOrder = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place Order"));
    }
}
