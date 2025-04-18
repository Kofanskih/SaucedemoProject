package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private SelenideElement productsHeader = $("[data-test=\"title\"]");
    private SelenideElement productItem = $("[name=\"add-to-cart-sauce-labs-backpack\"]");
    private SelenideElement cartBadge = $("[data-test=\"shopping-cart-badge\"]");

    public ProductsPage userShouldHaveCartLinkOnProductsPage(String productsText){
        productsHeader.shouldHave(Condition.exactTextCaseSensitive(productsText));
        return this;
    }

    public ProductsPage userAddItemToCart(String countItem){
        productItem.click();
        cartBadge.shouldBe(Condition.exactText(countItem));
        return this;
    }
}
