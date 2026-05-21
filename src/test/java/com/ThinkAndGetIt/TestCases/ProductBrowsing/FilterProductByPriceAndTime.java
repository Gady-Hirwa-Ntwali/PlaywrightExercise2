package com.ThinkAndGetIt.TestCases.ProductBrowsing;

import com.ThinkAndGetIt.Base.BaseTest;
import com.ThinkAndGetIt.ReusableMethods.OrderProductMethods;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;

import static com.ThinkAndGetIt.EndPoints.EndPoints.Product;
import static com.ThinkAndGetIt.ReusableMethods.OrderProductMethods.orderProducts;

public class FilterProductByPriceAndTime extends BaseTest {
    public void byPriceHigh(){
        orderProducts(page, "price-desc");

    }

    public void byPriceLow(){
        orderProducts(page, "price-asc");
    }

    public void byNewest(){
        orderProducts(page, "price-desc");
    }

    public void byPriceLowToHigh(){
        orderProducts(page, "price-desc");
    }

}
