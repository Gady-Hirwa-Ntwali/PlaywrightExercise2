package com.ThinkAndGetIt.TestCases.Authentication;

import com.ThinkAndGetIt.Base.BaseTest;
import com.microsoft.playwright.Locator;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {
    @Test
    public void createAccountTest(){
        Locator continueToCreateAccount = page.locator(".btn-ghost.text-base.py-4.px-8");
                continueToCreateAccount.click();
        Locator firstName = page.locator("input[placeholder='John']");
        firstName.fill("am not");
        Locator lastName = page.locator("input[placeholder='Doe']");
        lastName.fill("human");
        Locator emailAddress = page.locator("input[placeholder='you@example.com']");
        emailAddress.fill("example@gmail.com");
        Locator password = page.locator("input[placeholder='Min. 8 characters']");
        password.fill("Min. 8 characters");
        Locator createAccount = page.locator("button[type='submit']");
        createAccount.click();
        page.waitForTimeout(5000);

    }
}
