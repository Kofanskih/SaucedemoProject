package com.saucedemo.pageModels;

import lombok.Data;

@Data
public class UserLoginPageModel {
    private String userName;
    private String userPassword;

    public UserLoginPageModel userLogin(){
        this.userName = "standard_user";
        this.userPassword = "secret_sauce";
        return this;
    }

    public UserLoginPageModel lockedUserLogin(){
        this.userName = "locked_out_user";
        this.userPassword = "secret_sauce";
        return this;
    }

    public UserLoginPageModel incorrectUserLogin(){
        this.userName = "oioioioioioio";
        this.userPassword = "secret_sauce";
        return this;
    }
}
