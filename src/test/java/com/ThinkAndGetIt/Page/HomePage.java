package com.ThinkAndGetIt.Page;

import com.ThinkAndGetIt.Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BaseTest {

    Locator shopNow = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shop Now")).first();
    Locator flashDeal = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Flash Deals"));
    Locator shop = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Shop").setExact(true));
    Locator flash = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("⚡ Flash"));
    Locator feature = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Featured"));
    Locator search =       page.getByRole(AriaRole.BUTTON).first();

public ProductsPage shopNow()


}
