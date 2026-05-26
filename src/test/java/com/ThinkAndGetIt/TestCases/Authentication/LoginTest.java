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
    public static void SuccessfulTest(){
        String expectedUrl = properties.getProperty("baseUrl") + HOME;
        LoginMethods.loginForm(page, properties.getProperty("email"), properties.getProperty("password"));
        page.waitForURL("**/home");
        assertEquals(page.url(), expectedUrl);
    }

    @Test
    public void loginTestWithInvalidEmail(){
        String expectedUrl = properties.getProperty("baseUrl");
        LoginMethods.loginForm(page, "kldjflk@gmail.com", properties.getProperty("password"));
        page.waitForTimeout(5000);
        assertEquals(page.url(), expectedUrl);
    }

    @Test
    public void loginTestWithInvalidPassword(){
        String expectedUrl = properties.getProperty("baseUrl");
        LoginMethods.loginForm(page, properties.getProperty("email"), "dlskjflks");
        page.waitForTimeout(5000);
        assertEquals(page.url(), expectedUrl);
    }

}
