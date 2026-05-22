package com.ThinkAndGetIt.TestCases.ProductBrowsing;

import com.ThinkAndGetIt.Base.BaseTest;
import com.ThinkAndGetIt.ReusableMethods.OrderProductMethods;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.ThinkAndGetIt.EndPoints.EndPoints.Product;
import static com.ThinkAndGetIt.ReusableMethods.OrderProductMethods.*;
import static org.testng.Assert.assertEquals;
public class FilterProductByPriceAndTime extends BaseTest {
    @Test
    public void byPriceHigh() {

        OrderProductMethods.byPrice(page, "price_desc");
        Collections.sort(localOrder);
        Collections.reverse(localOrder);

        System.out.println("Expected Local Sorted Order: " + localOrder);
        System.out.println("Actual Browser Visual Order: " + browserOrder);
        page.waitForTimeout(7000);

        assertEquals(browserOrder, localOrder, "The web frontend failed to sort the items from high to low correctly!");
    }

    @Test
    public void byPriceLow(){
        String Url = properties.getProperty("baseUrl") + Product;
        page.navigate(Url);
        page.getByRole(AriaRole.COMBOBOX).selectOption("price_asc");
        page.waitForTimeout(3000);

        List<String> uiPrices = page.locator("a.group.card-hover div.flex.items-center.gap-2 span.font-display").allInnerTexts();

        System.out.println("Extracted UI Text Elements: " + uiPrices);

        List<Double> browserOrder = new ArrayList<>();
        for (String price : uiPrices) {
            String cleanPrice = price.replace("$", "").replace(",", "").trim();
            browserOrder.add(Double.parseDouble(cleanPrice));
        }
        List<Double> localOrder = new ArrayList<>(browserOrder);

        Collections.sort(localOrder);
        System.out.println("Expected Local Sorted Order: " + localOrder);
        System.out.println("Actual Browser Visual Order: " + browserOrder);
        page.waitForTimeout(7000);

        assertEquals(browserOrder, localOrder, "The web frontend failed to sort the items from high to low correctly!");
    }

    public void byNewest(){
        byTime(page, "newest");
    }

    public void byPopular(){
        byTime(page, "popular");
    }

    public void byTopRating(){
        byTime(page, "rating");
    }

}
