package com.saucedemo.utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:url.properties", "classpath:remote.url.properties"})
public interface OwnerConfig extends Config {
    @Key("main.url")
    String mainUrl();

    @Key("remote.url")
    String remoteUrl();
}
