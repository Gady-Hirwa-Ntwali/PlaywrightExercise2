package com.ThinkAndGetIt.TestCases.ProductBrowsing;

import com.ThinkAndGetIt.Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;

import static com.ThinkAndGetIt.EndPoints.EndPoints.Product;

public class FilterProductByPriceAndTime extends BaseTest {
    public void byPriceHigherToLow(){
        String Url = properties.getProperty("baseUrl") + Product;
        page.navigate(Url);
        Locator category = page.locator(".input.py-2.pr-8.pl-3.text-sm.appearance-none.cursor-pointer");
        category.selectOption(new SelectOption().setValue("price-desc"));

    }


}
