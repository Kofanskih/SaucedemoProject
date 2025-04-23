package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private SelenideElement cartTitle = $("[data-test=\"title\"]");
    private SelenideElement removeButton = $("[class=\"btn btn_secondary btn_small cart_button\"]");
    private SelenideElement removedItem = $x("//div[@class=\"removed_cart_item\"]");
    private SelenideElement continueShoppingButton = $("[name=\"continue-shopping\"]");

    public void checkUserOnTheCart(String cartHeader){
        cartTitle.shouldHave(Condition.exactText(cartHeader));
    }

    public CartPage userRemoveFirstItemFromCart(){
        removeButton.click();
        return this;
    }

    public void checkRemovedItem(){
        removedItem.shouldHave(Condition.attribute("class", "removed_cart_item"));

    }

    public ProductsPage userGoToContinueShopping(){
        continueShoppingButton.click();
        return new ProductsPage();
    }


}
