package com.ThinkAndGetIt.TestCases.CArtManagement;

import com.ThinkAndGetIt.Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.ThinkAndGetIt.TestCases.Navigation.NavigationTests.navigateToCart2;
import static com.ThinkAndGetIt.TestCases.Navigation.NavigationTests.navigateToProduct;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddProductToCart extends BaseTest {
    @Test
    public static void addItemByQuickAdd(){
        navigateToProduct();
        Locator item = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Quick Add")).first();
                item.click();
        navigateToCart2();
        Locator cartItem = page.getByText("Clear PVC Stadium Tote Bag$");
        assertThat(cartItem).isVisible();
    }


}
