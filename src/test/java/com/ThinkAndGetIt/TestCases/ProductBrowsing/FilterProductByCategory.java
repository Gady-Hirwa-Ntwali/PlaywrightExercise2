package com.ThinkAndGetIt.TestCases.ProductBrowsing;

import com.ThinkAndGetIt.Base.BaseTest;
import com.ThinkAndGetIt.EndPoints.EndPoints;
import com.ThinkAndGetIt.Pages.HomePage;
import com.ThinkAndGetIt.Pages.ProductsPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.regex.Pattern;

public class FilterProductByCategory extends BaseTest {
    private ProductsPage navigateToProductsPage() {
        page.navigate(properties.getProperty("baseUrl") +EndPoints.HOME);
        HomePage homePage = new HomePage(page);
        return homePage.clickShop();
    }

    @Test
    public void testFilterByAllProducts() {
        ProductsPage productsPage = navigateToProductsPage();
        productsPage.filterByAll();
    }

    @Test
    public void testFilterByBagsAndLuggage() {
        ProductsPage productsPage = navigateToProductsPage();
        productsPage.filterByBagsAndLuggage();
    }

    @Test
    public void testFilterByBeautyAndCare() {
        ProductsPage productsPage = navigateToProductsPage();
        productsPage.filterByBeautyAndCare();
    }

    @Test
    public void testFilterByElectronics() {
        ProductsPage productsPage = navigateToProductsPage();
        productsPage.filterByElectronics();
    }


    @Test
    public void testFilterByHomeAndLiving() {
        ProductsPage productsPage = navigateToProductsPage();
        productsPage.filterByHomeAndLiving();
    }

    @Test
    public void testFilterByKidsAndBaby() {
        ProductsPage productsPage = navigateToProductsPage();
        productsPage.filterByKidsAndBaby();
    }

    @Test
    public void testFilterByMensFashion() {
        ProductsPage productsPage = navigateToProductsPage();
        productsPage.filterByMensFashion();
    }

}