package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutCompletePage {
    private SelenideElement thankYouHeader = $x("//h2[@class=\"complete-header\"]");
    private SelenideElement backHomeButton = $x("//button[@id=\"back-to-products\"]");

    public void checkUserCompleteCheckout(String thankYou){
        thankYouHeader.shouldHave(Condition.exactText(thankYou));
    }

    public ProductsPage userClickBackHomeButton(){
        backHomeButton.click();
        return new ProductsPage();
    }


}
