package com.spotify.auth2.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        try {
            String configFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                    + File.separator + "resources" + File.separator + "config.properties";
            properties = PropertyUtils.propertyLoader(configFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to load property file");
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientId(){
        String prop = properties.getProperty("client_id");
        if(StringUtils.isBlank(prop)){
            throw new RuntimeException("Property client_id is not defined");
        }else {
            return prop;
        }
    }

    public String getClientSecret(){
        String prop = properties.getProperty("client_secret");
        if(StringUtils.isBlank(prop)){
            throw new RuntimeException("Property client_secret is not defined");
        }else {
            return prop;
        }
    }

    public String getRefreshToken(){
        String prop = properties.getProperty("refresh_token");
        if(StringUtils.isBlank(prop)){
            throw new RuntimeException("Property refresh_token is not defined");
        }else {
            return prop;
        }
    }

    public String getGrantType(){
        String prop = properties.getProperty("grant_type");
        if(StringUtils.isBlank(prop)){
            throw new RuntimeException("Property grant_type is not defined");
        }else {
            return prop;
        }
    }

    public String getUserId(){
        String prop = properties.getProperty("user_id");
        if(StringUtils.isBlank(prop)){
            throw new RuntimeException("Property user_id is not defined");
        }else {
            return prop;
        }
    }
}
