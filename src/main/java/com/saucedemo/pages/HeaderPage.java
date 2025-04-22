package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private SelenideElement burgerButton = $("[id=\"react-burger-menu-btn\"]");
    private SelenideElement sideBarSection = $("[class=\"bm-menu-wrap\"]");
    private String attributeName = "aria-hidden";
    private SelenideElement aboutButton = $("[id=\"about_sidebar_link\"]");
    private SelenideElement saucelabsHeader = $("[class=\"MuiTypography-root MuiTypography-h1 css-152qxt\"]");
    private SelenideElement logoutButton = $("[id=\"logout_sidebar_link\"]");


    @SneakyThrows
    public HeaderPage openSideBar(){
        burgerButton.click();
        Thread.sleep(700);
        return this;
    }

    public void checkSideBarIsDisplayed(String expectedAttributeValue){
        sideBarSection.shouldHave(Condition.attribute(attributeName, expectedAttributeValue));
    }

    public HeaderPage openAboutLink(){
        aboutButton.click();
        return this;
    }

    public  void checkTransitionToAboutPage(String header){
        saucelabsHeader.shouldHave(Condition.exactText(header));
    }

    public LoginPage userLogout(){
        logoutButton.click();
        return new LoginPage();
    }

}
