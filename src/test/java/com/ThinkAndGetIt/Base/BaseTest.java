package com.ThinkAndGetIt.Base;

import com.ThinkAndGetIt.Utilities.Utils;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {
    public Properties properties;
    public Page page;

    @BeforeMethod
    public void baseTest(){
        properties = Utils.loadProperties("src/test/resources/Config.properties");
        page = Playwright.create().chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        ).newPage();
        page.navigate(properties.getProperty("baseUrl"));
    }
}
