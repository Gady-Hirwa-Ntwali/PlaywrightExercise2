package com.ThinkAndGetIt.TestCases.Checkout;

import com.ThinkAndGetIt.Base.BaseTest;
import com.ThinkAndGetIt.TestCases.Authentication.CreateAccountTest;
import com.ThinkAndGetIt.TestCases.Authentication.LoginTest;
import com.ThinkAndGetIt.TestCases.CArtManagement.AddProductToCart;
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
        CreateAccountTest.createAccountTestSuccessfully();
        AddProductToCart.addItemByQuickAdd();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Checkout")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add new address")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First name")).fill("am not ");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last name")).fill("a human");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone number")).fill("234567898765");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street address")).fill("kigali");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("City")).fill("kigali");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("State / Region")).fill("kigali");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Country")).fill("Rwanda");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Postal code (optional)")).fill("00000");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save Address")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue to Payment")).click();
        page.getByText("💵Cash on DeliveryPay when").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Review Order")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place Order")).click();
        page.waitForTimeout(10000);
        boolean successfulMessage = page.getByText("Order placed successfully").isVisible();
        assertTrue(successfulMessage);
    }

}
