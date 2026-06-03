package com.ThinkAndGetIt.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CheckoutPage {
    private final Page page;
    private final Locator addNewAddressBtn;
    private final Locator fName;
    private final Locator lName;
    private final Locator phone;
    private final Locator streetAddress;
    private final Locator city;
    private final Locator state;
    private final Locator country;
    private final Locator postalCode;
    private final Locator saveAddress;
    private final Locator continueToPayment;
    private final Locator cancel;


    public CheckoutPage(Page page){
        this.page = page;
        this.addNewAddressBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add new address"));
        this.fName = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First name"));
        this.lName = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last name"));
        this.phone = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone number"));
        this.streetAddress = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street address"));
        this.city = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("City"));
        this.state = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("State / Region"));
        this.country = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Country"));
        this.postalCode = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Postal code (optional)"));
        this.cancel = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
        this.saveAddress = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save Address"));
        this.continueToPayment = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue to Payment"));
    }

    public void clickAddNewAddress(){
        addNewAddressBtn.click();
    }

    public void addNewAddress(String frstName, String lstName, String tel, String address, String theCity, String theState, String theCountry, String postCode){
        clickAddNewAddress();
        fName.fill(frstName);
        lName.fill(lstName);
        phone.fill(tel);
        streetAddress.fill(address);
        city.fill(theCity);
        state.fill(theState);
        country.fill(theCountry);
        postalCode.fill(postCode);
    }

    public void clickSavaAddress(){
        saveAddress.click();
    }

    public void clickCancelAddress(){
        cancel.click();
    }

    public void clickContinueToPayment(){
        continueToPayment.click();
    }

}
