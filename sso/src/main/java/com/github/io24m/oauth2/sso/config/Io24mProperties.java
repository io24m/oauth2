package com.github.io24m.oauth2.sso.config;

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

    private String indexPage;

    public String getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(String name) {
        this.indexPage = name;
    }
}
