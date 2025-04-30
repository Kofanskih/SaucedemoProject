package com.saucedemo.pageModels;

import io.qameta.allure.Step;
import lombok.Data;

@Data
public class UserLoginPageModel {
    private String userName;
    private String userPassword;

    @Step("Fill correct user login data")
    public UserLoginPageModel userLogin(){
        this.userName = "standard_user";
        this.userPassword = "secret_sauce";
        return this;
    }

    @Step("Fill locked user login data")
    public UserLoginPageModel lockedUserLogin(){
        this.userName = "locked_out_user";
        this.userPassword = "secret_sauce";
        return this;
    }

    @Step("Fill incorrect user login data")
    public UserLoginPageModel incorrectUserLogin(){
        this.userName = "oioioioioioio";
        this.userPassword = "secret_sauce";
        return this;
    }
}
