package com.ThinkAndGetIt.ReusableMethods;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import static com.ThinkAndGetIt.EndPoints.EndPoints.Product;

public class OrderProductMethods {

    public static void orderProducts(Page page, String value){
        String Url = properties.getProperty("baseUrl") + Product;
        page.navigate(Url);
        Locator category = page.locator(".input.py-2.pr-8.pl-3.text-sm.appearance-none.cursor-pointer");
        category.selectOption(new SelectOption().setValue(value));

    }
}
