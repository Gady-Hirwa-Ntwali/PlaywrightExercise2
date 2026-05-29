package com.ThinkAndGetItFrontEnd.TestCases.ProductBrowsing;

import com.ThinkAndGetItFrontEnd.Base.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.ThinkAndGetItFrontEnd.TestCases.Navigation.NavigationTests.navigateToProduct;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FilterProductByCategory extends BaseTest {
    @Test
    public void filterByBagAndLuggage() {
        navigateToProduct();
        page.locator("//button[normalize-space()='Bags & Luggage']").click();
        page.waitForTimeout(5000);
        List<String> bags = page.locator("a div p").allInnerTexts();
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
