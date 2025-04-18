package com.saucedemo.utils;

import org.aeonbits.owner.ConfigFactory;

public class OwnerReadUrl {

    public static String readMainUrl(){
        OwnerConfig ownerConfig = ConfigFactory.create(OwnerConfig.class);
        return ownerConfig.mainUrl();

    }
}
