package com.ThinkAndGetIt.TestCases.Checkout;

import com.ThinkAndGetIt.Base.BaseTest;
import com.ThinkAndGetIt.TestCases.Authentication.LoginTest;
import com.ThinkAndGetIt.TestCases.CArtManagement.AddProductToCart;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.ThinkAndGetIt.EndPoints.EndPoints.Login;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutWithoutLogin(){
        AddProductToCart.addItemByQuickAdd();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Checkout")).click();
        page.waitForTimeout(2000);
        assertThat(page).hasURL(properties.getProperty("baseUrl") + Login);
    }

    @Test
    public void checkoutLoggedIn(){
        LoginTest.SuccessfulTest();
        AddProductToCart.addItemByQuickAdd();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Checkout")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue to Payment")).click();
        page.getByText("💵Cash on DeliveryPay when").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Review Order")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place Order")).click();
        page.waitForTimeout(10000);
        boolean successfulMessage = page.getByText("Order placed successfully").isVisible();
        assertTrue(successfulMessage);
    }

}
