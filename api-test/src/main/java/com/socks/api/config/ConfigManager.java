package com.socks.api.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigManager {

    private static final ProjectConfig CONFIG = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    private ConfigManager() {
    }

    public static ProjectConfig getConfig() {
        return CONFIG;
    }
}
