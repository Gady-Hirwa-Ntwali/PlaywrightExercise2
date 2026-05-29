package com.ThinkAndGetItFrontEnd.ReusableMethods;

import com.ThinkAndGetItFrontEnd.Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.ArrayList;
import java.util.List;

import static com.ThinkAndGetItFrontEnd.EndPoints.EndPoints.Product;

public class OrderProductMethods extends BaseTest {
    public static List<Double> browserOrder = new ArrayList<>();
    public static List<String> uiPrices;
    public static List<Double> localOrder;
    static String Url = properties.getProperty("baseUrl") + Product;
    static Locator category = page.getByRole(AriaRole.COMBOBOX);

    public static void byPrice(Page page, String value){
        page.navigate(Url);
        category.selectOption(value);
        page.waitForTimeout(3000);

        uiPrices = page.locator("a.group.card-hover div.flex.items-center.gap-2 span.font-display").allInnerTexts();

        System.out.println("Extracted UI Text Elements: " + uiPrices);

        for (String price : uiPrices) {
            String cleanPrice = price.replace("$", "").replace(",", "").trim();
            browserOrder.add(Double.parseDouble(cleanPrice));
        }
        localOrder = new ArrayList<>(browserOrder);
    }

    public static void byTime(Page page, String value){
        page.navigate(Url);
        category.selectOption(value);

    }
}