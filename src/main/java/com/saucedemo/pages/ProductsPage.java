package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private SelenideElement productsHeader = $("[data-test=\"title\"]");
    private SelenideElement productItem = $("[name=\"add-to-cart-sauce-labs-backpack\"]");
    private SelenideElement cartBadge = $("[data-test=\"shopping-cart-badge\"]");
    private SelenideElement removeButton = $("[id=\"remove-sauce-labs-backpack\"]");

    public ProductsPage userShouldHaveCartLinkOnProductsPage(String productsText){
        productsHeader.shouldHave(Condition.exactTextCaseSensitive(productsText));
        return this;
    }

    public ProductsPage userAddOneItemToCart(){
        productItem.click();
        return this;
    }

    public void checkCountOfItemInTheCart(String countItem){
        cartBadge.shouldBe(Condition.exactText(countItem));
    }

    public ProductsPage userRemoveOneAddedItemFromCartOnTheProductPage(){
        removeButton.click();
        return this;
    }

    public void checkEmptyCountCartBadge(){
        cartBadge.shouldHave(Condition.hidden);
    }
}
