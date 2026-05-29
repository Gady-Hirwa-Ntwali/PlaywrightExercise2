package com.ThinkAndGetIt.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PaymentPage {
    private final Page page;
    private final Locator cash;
    private final Locator bank;
    private final Locator mobile;
    private final Locator orderNote;
    private final Locator back;
    private final Locator reviewOrder;

    public PaymentPage(Page page){
        this.page = page;
        this.cash = page.getByText("💵Cash on DeliveryPay when");
        this.bank = page.getByText("🏦Bank TransferTransfer to");
        this.mobile = page.getByText("📱Mobile MoneyTransfer via");
        this.orderNote = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Any special instructions…"));
        this.back = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Back"));
        this.reviewOrder = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Review Order"));

    }

    public void payByCash(){
        cash.click();
    }

    public void payByBank(){
        bank.click();
    }

    public void payByMobile(){
        mobile.click();
    }

    public void orderNote(String note){
        orderNote.fill(note);
    }

    public void clickBack(){
        back.click();
    }

    public void clickReviewOrder(){
        reviewOrder.click();
    }
}
