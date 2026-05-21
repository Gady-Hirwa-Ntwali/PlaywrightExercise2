package com.ThinkAndGetIt.ReusableMethods;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginMethods {
    public static void loginForm(Page page, String email, String password){
        Locator navigateToLoginPage = page.locator("//a[normalize-space()='Sign in']");
        navigateToLoginPage.click();
        Locator Email = page.locator("input[type='email']");
        Email.fill(email);
        Locator Password = page.locator("input[type='password']");
        Password.fill(password);
        Locator signIn = page.locator("button[type='submit']");
        signIn.click();
    }
}
