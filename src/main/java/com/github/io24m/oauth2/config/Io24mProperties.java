package com.github.io24m.oauth2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lk1
 * @description
 * @create 2021-03-10 11:18
 */
@EnableConfigurationProperties(Io24mProperties.class)
@ConfigurationProperties(prefix = "io24m")
@Configuration
public class Io24mProperties {
    private static final String NAME = "io24m";

    private String name = NAME;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
