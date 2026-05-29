package com.ThinkAndGetItFrontEnd.ReusableMethods;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CreateAccountMethods{
    public static void createAccountForm(Page page, String firstname, String lastname, String email, String password){
        Locator continueToCreateAccount = page.locator(".btn-ghost.text-base.py-4.px-8");
        continueToCreateAccount.click();
        Locator firstName = page.locator("input[placeholder='John']");
        firstName.fill(firstname);
        Locator lastName = page.locator("input[placeholder='Doe']");
        lastName.fill(lastname);
        Locator emailAddress = page.locator("input[placeholder='you@example.com']");
        emailAddress.fill(email);
        Locator Password = page.locator("input[placeholder='Min. 8 characters']");
        Password.fill(password);
        Locator createAccount = page.locator("button[type='submit']");
        createAccount.click();
        page.waitForURL("**/home");
    }
}
