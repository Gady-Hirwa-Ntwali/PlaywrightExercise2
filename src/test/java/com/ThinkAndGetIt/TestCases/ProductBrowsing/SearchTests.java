package com.ThinkAndGetIt.TestCases.ProductBrowsing;

import com.ThinkAndGetIt.Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.util.List;

import static com.ThinkAndGetIt.EndPoints.EndPoints.Product;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {

    @Test
    public void searchBag(){
        String Url = properties.getProperty("baseUrl") + Product;
        page.navigate(Url);
        page.getByRole(AriaRole.BUTTON).first().click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search products, brands,")).fill("bag");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search products, brands,")).press("Enter");
        page.waitForTimeout(3000);
        List<String> category = page.locator("a div p").allInnerTexts();
        System.out.println(category);
        for (String itemName : category) {
            String normalizedName = itemName.toLowerCase();
            assertTrue(
                    normalizedName.contains("bag"),
                    "not bags only in here! Found an invalid item named: " + itemName
            );
        }
    }

    @Test
    public void searchShorts(){
        String Url = properties.getProperty("baseUrl") + Product;
        page.navigate(Url);
        page.getByRole(AriaRole.BUTTON).first().click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search products, brands,")).fill("shorts");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search products, brands,")).press("Enter");
        page.waitForTimeout(3000);
        List<String> category = page.locator("a div h3").allInnerTexts();
        System.out.println(category);
        for (String itemName : category) {
            String normalizedName = itemName.toLowerCase();
            assertTrue(
                    normalizedName.contains("shorts"),
                    "not shorts only in here! Found an invalid item named: " + itemName
            );
        }
    }

    @Test
    public void searchUnavailableProduct(){
        String Url = properties.getProperty("baseUrl") + Product;
        page.navigate(Url);
        page.getByRole(AriaRole.BUTTON).first().click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search products, brands,")).fill("hat");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search products, brands,")).press("Enter");
        page.waitForTimeout(3000);
        Locator message = page.getByText("No results for \"hat\"");
        assertThat(message).isVisible();
    }

}
