package com.saucedemo.pages;

import com.codeborne.selenide.Selenide;

import static com.saucedemo.utils.OwnerReadUrl.readMainUrl;

public class BasePage {

    public BasePage open(){
        Selenide.open(readMainUrl());
        return new BasePage();
    }
}
