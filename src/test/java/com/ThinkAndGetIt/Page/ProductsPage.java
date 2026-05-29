package com.ThinkAndGetIt.Page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.ThinkAndGetIt.Base.BaseTest.page;

public class ProductsPage {
    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("All")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Bags & Luggage")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Beauty & Care")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Electronics")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Fruits-Decor")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Home & Living")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Kids & Baby")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Men's Fashion").setExact(true)).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sports & Fitness")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Women's Fashion")).click();
}
