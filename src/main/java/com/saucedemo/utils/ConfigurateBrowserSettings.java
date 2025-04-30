package com.saucedemo.utils;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

public class ConfigurateBrowserSettings {

    @Step("Set up browser")
    public void setUp(){
        Configuration.browserSize = "1980x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 5;
        Configuration.headless = true;
    }
}
