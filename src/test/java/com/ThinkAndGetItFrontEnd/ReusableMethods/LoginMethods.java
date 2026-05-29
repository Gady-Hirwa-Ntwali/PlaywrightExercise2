package com.ThinkAndGetItFrontEnd.ReusableMethods;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.ThinkAndGetItFrontEnd.TestCases.Navigation.NavigationTests.navigateToLogin;

public class LoginMethods {
    public static void loginForm(Page page, String email, String password){
        navigateToLogin();
        Locator Email = page.locator("input[type='email']");
        Email.fill(email);
        Locator Password = page.locator("input[type='password']");
        Password.fill(password);
        Locator signIn = page.locator("button[type='submit']");
        signIn.click();
    }
}
