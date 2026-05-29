package com.ThinkAndGetIt.Pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    // 1. Declare the Page and Locators at the class level
    private final Page page;
    private final Locator shopNow;
    private final Locator flashDeal;
    private final Locator shop;
    private final Locator flash;
    private final Locator feature;
    private final Locator search;

    public HomePage(Page page) {
        this.page = page;
        this.shopNow = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shop Now")).first();
        this.flashDeal = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Flash Deals"));
        this.shop = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shop").setExact(true));
        this.flash = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("⚡ Flash"));
        this.feature = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Featured"));
        this.search = page.getByRole(AriaRole.BUTTON).first();
    }

    public ProductsPage clickShopNow() {
        shopNow.click();
        return new ProductsPage(page);
    }
}