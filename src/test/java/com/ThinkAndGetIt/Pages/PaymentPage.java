package com.ThinkAndGetIt.Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PaymentPage {
    Locator
    public PaymentPage(Page page){
        page.getByText("💵Cash on DeliveryPay when").click();
        page.getByText("🏦Bank TransferTransfer to").click();
        page.getByText("📱Mobile MoneyTransfer via").click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Any special instructions…")).click();
    }
}
