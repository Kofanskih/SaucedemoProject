package com.saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.saucedemo.pageModels.UserLoginPageModel;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement userName = $("[id=\"user-name\"]");
    private final SelenideElement password = $("[id=\"password\"]");
    private final SelenideElement loginButton = $("[id=\"login-button\"]");
    //private final SelenideElement warningMessage = $("[class=\"error-message-container error\"]");
    private final SelenideElement warningMessage = $x("//h3");
    private SelenideElement loginLogo = $("[class=\"login_logo\"]");

    public ProductsPage fillLoginDataWithUserModel(UserLoginPageModel userLoginPageModel){
        userName.setValue(userLoginPageModel.getUserName());
        password.setValue(userLoginPageModel.getUserPassword());
        loginButton.click();
        return new ProductsPage();
    }

    public LoginPage checkWarningMessage(String warningMessageText){
        warningMessage.shouldHave(Condition.text(warningMessageText));
        return this;
    }

    public void checkUserLogout(String logo){
        loginLogo.shouldHave(Condition.exactText(logo));
    }
}
