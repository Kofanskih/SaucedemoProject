package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutOverviewPage {
    private SelenideElement checkoutOverviewHeader = $x("//span[@data-test=\"title\"]");
    private SelenideElement cancelButton = $x("//button[@id=\"cancel\"]");
    private SelenideElement finishButton = $x("//button[@id=\"finish\"]");


    public void checkUserGoToCheckoutOverview(String header) {
        checkoutOverviewHeader.shouldHave(Condition.exactText(header));
    }

    public ProductsPage userClickCancelButton(){
        cancelButton.click();
        return new ProductsPage();
    }

    public CheckoutCompletePage userFinishOrder(){
        finishButton.click();
        return new CheckoutCompletePage();
    }

}
