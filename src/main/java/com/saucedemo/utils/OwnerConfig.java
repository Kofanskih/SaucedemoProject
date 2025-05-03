package com.saucedemo.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:url.properties"})
public interface OwnerConfig extends Config {
    @Key("main.url")
    String mainUrl();

    @Key("localhost.remote")
    String remoteUrl();
}
