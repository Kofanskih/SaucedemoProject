package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {
    private SelenideElement productsHeader = $("[data-test=\"title\"]");

    public ProductsPage userShouldHaveCartLinkOnProductsPage(String productsText){
        productsHeader.shouldHave(Condition.exactTextCaseSensitive(productsText));
        return this;
    }
}
