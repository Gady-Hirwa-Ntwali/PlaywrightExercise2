package com.ThinkAndGetItFrontEnd.TestCases.Authentication;

import com.ThinkAndGetItFrontEnd.Base.BaseTest;
import com.ThinkAndGetItFrontEnd.ReusableMethods.LoginMethods;
import org.testng.annotations.Test;

import static com.ThinkAndGetItFrontEnd.EndPoints.EndPoints.HOME;
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
