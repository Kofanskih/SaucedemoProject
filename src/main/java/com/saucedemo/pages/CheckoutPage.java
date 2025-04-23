package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutPage {
    private SelenideElement checkoutTitle = $x("//span[@class=\"title\"]");

    public void checkUserOnTheCheckoutPage(String header){
        checkoutTitle.shouldHave(Condition.exactText(header));
    }
}
