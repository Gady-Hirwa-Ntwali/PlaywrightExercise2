package com.ThinkAndGetIt.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    private final Page page;
    private final Locator shopNow;
    private final Locator flashDeal;
    private final Locator shop;
    private final Locator flash;
    private final Locator feature;
    private final Locator search;
    private final Locator cartBtn;

    public HomePage(Page page) {
        this.page = page;
        this.shopNow = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shop Now")).first();
        this.flashDeal = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Flash Deals"));
        this.shop = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shop").setExact(true));
        this.flash = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("⚡ Flash"));
        this.feature = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Featured"));
        this.search = page.getByRole(AriaRole.BUTTON).first();
        this.cartBtn =  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("1"));

    }

    public ProductsPage clickShopNow() {
        shopNow.click();
        return new ProductsPage(page);
    }

    public ProductsPage clickShop() {
        shop.click();
        return new ProductsPage(page);
    }

    public ProductsPage clickFlashDeals() {
        flashDeal.click();
        return new ProductsPage(page);
    }

    public ProductsPage clickFlash() {
        flash.click();
        return new ProductsPage(page);
    }

    public ProductsPage clickFeatured() {
        feature.click();
        return new ProductsPage(page);
    }

    public void clickSearchIcon() {
        search.click();
    }

    public CartPage clickCartButton(){
        cartBtn.click();
        return new CartPage(page);
    }
}