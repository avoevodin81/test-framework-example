package com.socks.api.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties", "local.properties"})
public interface ProjectConfig extends Config {
    @DefaultValue("test")
    String env();

    @Key("${env}.baseUrl")
    String baseUrl();

    @Key("${env}.locale")
    String locale();

    @Key("${env}.logging")
    boolean logging();
}
