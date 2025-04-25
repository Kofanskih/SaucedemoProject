package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.saucedemo.pageModels.UserCheckoutPageModel;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutPage {
    private SelenideElement checkoutTitle = $x("//span[@class=\"title\"]");
    private SelenideElement cancelButton = $x("//button[@id=\"cancel\"]");
    private SelenideElement inputFirstName = $x("//input[@id=\"first-name\"]");
    private SelenideElement inputLastName = $x("//input[@id=\"last-name\"]");
    private SelenideElement inputPostalCode = $x("//input[@id=\"postal-code\"]");
    private SelenideElement continueButton = $x("//input[@id=\"continue\"]");
    private SelenideElement warningMessage = $x("//h3[@data-test=\"error\"]");

    public void checkUserOnTheCheckoutPage(String header){
        checkoutTitle.shouldHave(Condition.exactText(header));
    }

    public CartPage userCancelCheckout(){
        cancelButton.click();
        return new CartPage();
    }

    public CheckoutOverviewPage fillCheckoutInfo(UserCheckoutPageModel userCheckoutPageModel){
        inputFirstName.setValue(userCheckoutPageModel.getFirstName());
        inputLastName.setValue(userCheckoutPageModel.getLastName());
        inputPostalCode.setValue(userCheckoutPageModel.getPostalCode());
        continueButton.click();
        return new CheckoutOverviewPage();
    }

    public void checkWarningMessageAfterFillIncorrectData(String warning){
        warningMessage.shouldHave(Condition.exactText(warning));
    }
}
