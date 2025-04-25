package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {
    private SelenideElement productsHeader = $("[data-test=\"title\"]");
    private SelenideElement productFirstItem = $x("//div[@class=\"inventory_item\"][1]//button[@class=\"btn btn_primary btn_small btn_inventory \"]");
    private SelenideElement cartBadge = $("[data-test=\"shopping-cart-badge\"]");
    private SelenideElement removeButton = $("[id=\"remove-sauce-labs-backpack\"]");
    private SelenideElement sortContainer = $("[data-test=\"product-sort-container\"]");
    private SelenideElement actualSortOption = $("[data-test=\"active-option\"]");
    private SelenideElement shoppingCartButton = $("[class=\"shopping_cart_link\"]");

    public ProductsPage checkHeaderOnProductsPage(String productsText){
        productsHeader.shouldHave(Condition.exactTextCaseSensitive(productsText));
        return this;
    }

    public ProductsPage userAddFirstItemToCart(){
        productFirstItem.click();
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

    public ProductsPage sortItemsBySelectedOption(SelenideElement element){
        sortContainer.click();
        element.click();
        return this;
    }

    public void checkSortingOption(String selectedElement){
        actualSortOption.shouldHave(Condition.exactText(selectedElement));
    }

    public CartPage userGoToCart(){
        shoppingCartButton.click();
        return new CartPage();
    }

}
