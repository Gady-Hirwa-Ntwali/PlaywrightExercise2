package com.ThinkAndGetIt.TestCases.Navigation;

import com.ThinkAndGetIt.Base.BaseTest;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.ThinkAndGetIt.EndPoints.EndPoints.*;

public class NavigationTests extends BaseTest {
    public static void navigate(String endpoint){
        page.navigate(properties.getProperty("baseUrl") + endpoint);
    }
    public void navigateToHome(){
        navigate(HOME);
    }
    public static void navigateToProduct(){
        navigate(Product);
    }

    public void navigateToCart(){
        navigate(Cart);
    }

    public static void navigateToCart2(){
        page.getByRole(AriaRole.BUTTON).nth(1).click();
    }

    public static void navigateToCheckout(){
        navigate(Checkout);
    }

    public static void navigateToLogin(){
        navigate(Login);
    }
}
