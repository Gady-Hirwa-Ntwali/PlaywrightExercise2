package com.ThinkAndGetIt.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductsPage {

  private final Locator allBtn;
    private final Locator bagsAndLuggageBtn;
    private final Locator beautyAndCareBtn;
    private final Locator electronicsBtn;
    private final Locator fruitsDecorBtn;
    private final Locator homeAndLivingBtn;
    private final Locator kidsAndBabyBtn;
    private final Locator mensFashionBtn;
    private final Locator searchBtn;

    public ProductsPage(Page page) {

        this.allBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("All"));
        this.bagsAndLuggageBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bags & Luggage"));
        this.beautyAndCareBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Beauty & Care"));
        this.electronicsBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Electronics"));
        this.fruitsDecorBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fruits-Decor"));
        this.homeAndLivingBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Home & Living"));
        this.kidsAndBabyBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kids & Baby"));
        this.mensFashionBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Men's Fashion"));
        this.searchBtn =       page.getByRole(AriaRole.BUTTON).first();

    }

    public void filterByAll() {
        allBtn.click();
    }

    public void filterByBagsAndLuggage() {
        bagsAndLuggageBtn.click();
    }

    public void filterByBeautyAndCare() {
        beautyAndCareBtn.click();
    }

    public void filterByElectronics() {
        electronicsBtn.click();
    }

    public void filterByFruitsDecor() {
        fruitsDecorBtn.click();
    }

    public void filterByHomeAndLiving() {
        homeAndLivingBtn.click();
    }

    public void filterByKidsAndBaby() {
        kidsAndBabyBtn.click();
    }

    public void filterByMensFashion() {
        mensFashionBtn.click();
    }

    public void searchProduct(){
      searchBtn.click();
    }
}
