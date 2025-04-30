package com.saucedemo.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.saucedemo.utils.OwnerReadUrl.readMainUrl;

public class BasePage {

    @Step("Open main page")
    public BasePage open(){
        Selenide.open(readMainUrl());
        return new BasePage();
    }
}
