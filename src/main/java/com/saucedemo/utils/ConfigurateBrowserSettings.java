package com.saucedemo.utils;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.openqa.selenium.MutableCapabilities;

public class ConfigurateBrowserSettings {
    public final String URL_PATH = ":4444/wd/hub";

    @Step("Set up browser")
    public void setUp(){
        Configuration.browserSize = "1980x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 5;
        Configuration.headless = true;
    }

    public void setUpRemote(String url){
        Configuration.remote = url + URL_PATH;
        Configuration.browserVersion = "127.0";
        Configuration.browser = "chrome";
        Configuration.timeout = 5;
        MutableCapabilities options = new MutableCapabilities();
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        options.setCapability("screenResolution", "1920x1080x24");

        Configuration.browserCapabilities.setCapability("selenoid:options", options);

    }
}
