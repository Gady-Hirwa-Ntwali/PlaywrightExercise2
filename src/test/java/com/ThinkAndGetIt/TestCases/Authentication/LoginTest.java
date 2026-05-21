package com.ThinkAndGetIt.TestCases.Authentication;

import com.ThinkAndGetIt.Base.BaseTest;
import com.ThinkAndGetIt.EndPoints.EndPoints;
import com.ThinkAndGetIt.ReusableMethods.LoginMethods;
import com.microsoft.playwright.Locator;
import org.testng.annotations.Test;

import static com.ThinkAndGetIt.EndPoints.EndPoints.HOME;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        String expectedUrl = properties.getProperty("baseUrl") + HOME;
        LoginMethods.loginForm(page, properties.getProperty("email"), properties.getProperty("password"));
        assertEquals(page.url(), expectedUrl);
    }

    @Test
    public void loginTestWithInvalidEmail(){
        Locator navigateToLoginPage = page.locator("//a[normalize-space()='Sign in']");
        navigateToLoginPage.click();
        Locator email = page.locator("input[type='email']");
        email.fill("akdsjflksd@tdksjlkf.com");
        Locator password = page.locator("input[type='password']");
        password.fill("Admin@123456");
        Locator signIn = page.locator("button[type='submit']");
        signIn.click();
        page.waitForTimeout(15000);
        assertEquals(page.url(), "https://think-and-get-it-frontend.onrender.com/login");
    }

    @Test
    public void loginTestWithInvalidPassword(){
        Locator navigateToLoginPage = page.locator("//a[normalize-space()='Sign in']");
        navigateToLoginPage.click();
        Locator email = page.locator("input[type='email']");
        email.fill("akdsjflksd@tdksjlkf.com");
        Locator password = page.locator("input[type='password']");
        password.fill("Admin@123456klsjdlkfjoeilkjfdsoids");
        Locator signIn = page.locator("button[type='submit']");
        signIn.click();
        page.waitForTimeout(15000);
        assertEquals(page.url(), "https://think-and-get-it-frontend.onrender.com/login");
    }

}
