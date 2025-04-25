package com.saucedemo.pageModels;

import lombok.Data;

@Data
public class UserCheckoutPageModel {
    private String firstName;
    private String lastName;
    private String postalCode;


    public UserCheckoutPageModel fullUserData(){
        this.firstName = "Jack";
        this.lastName = "Douson";
        this.postalCode = "098765";
        return this;
    }

    public UserCheckoutPageModel userDataWithoutFirstName(){
        this.lastName = "Douson";
        this.postalCode = "098765";
        return this;
    }

    public UserCheckoutPageModel userDataWithoutLastName(){
        this.firstName = "Jack";
        this.postalCode = "098765";
        return this;
    }

    public UserCheckoutPageModel userDataWithoutPostalCode(){
        this.firstName = "Jack";
        this.lastName = "Douson";
        return this;
    }

    public UserCheckoutPageModel userEmptyData(){
        return this;
    }

}
