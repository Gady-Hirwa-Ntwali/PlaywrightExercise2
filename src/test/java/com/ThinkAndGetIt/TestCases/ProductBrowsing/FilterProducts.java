package com.ThinkAndGetIt.TestCases.ProductBrowsing;

import com.ThinkAndGetIt.Base.BaseTest;
import com.ThinkAndGetIt.EndPoints.EndPoints;
import com.microsoft.playwright.Locator;
import org.testng.annotations.Test;

import java.util.List;

import static com.ThinkAndGetIt.EndPoints.EndPoints.HOME;
import static com.ThinkAndGetIt.EndPoints.EndPoints.Product;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FilterProducts extends BaseTest {
    @Test
    public void filterByBagAndLuggage() {
        String Url = properties.getProperty("baseUrl") + Product;
        page.navigate(Url);
        page.waitForTimeout(5000);
        List<String> bags = page.locator("a div h3").allInnerTexts();
        System.out.println(bags);
        for (String itemName : bags) {
            String normalizedName = itemName.toLowerCase();
            assertTrue(
                    normalizedName.contains("bag"),
                    "not bags only in here! Found an invalid item named: " + itemName
            );
        }
    }
}
