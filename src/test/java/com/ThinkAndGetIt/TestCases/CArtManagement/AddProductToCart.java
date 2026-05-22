package com.ThinkAndGetIt.TestCases.CArtManagement;

import com.ThinkAndGetIt.Base.BaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.ThinkAndGetIt.EndPoints.EndPoints.Product;

public class AddProductToCart extends BaseTest {
    @Test
    public void addSingleItem(){
        page.navigate(properties.getProperty("baseUrl") + Product);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Quick Add")).first().click();
    }

}
