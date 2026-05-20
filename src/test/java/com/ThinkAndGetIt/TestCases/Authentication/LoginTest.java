package com.ThinkAndGetIt.TestCases.Authentication;

import com.ThinkAndGetIt.Base.BaseTest;
import com.microsoft.playwright.Locator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        Locator navigateToLoginPage = page.locator("//a[normalize-space()='Sign in']");
        navigateToLoginPage.click();
        Locator email = page.locator("input[type='email']");
        email.fill("admin@thinkandgetit.com");
        Locator password = page.locator("input[type='password']");
        password.fill("Admin@123456");
        Locator signIn = page.locator("button[type='submit']");
        signIn.click();
        page.waitForTimeout(5000);
        assertEquals(page.url(), "https://think-and-get-it-frontend.onrender.com/home");
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

}
