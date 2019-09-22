package com.zjf.example.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Harry
 */
@Component
public class EnvironmentUtils implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getActiveProfile() {
        if (environment.getActiveProfiles().length > 0) {
            return environment.getActiveProfiles()[0];
        }
        return environment.getDefaultProfiles()[0];
    }
    public String getProperty(String key){
        return environment.getProperty(key);
    }
}
