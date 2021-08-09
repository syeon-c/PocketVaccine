package com.pocketvaccine.PocketVaccine.common;

import javax.servlet.http.HttpSessionListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig {

    @Bean
    public HttpSessionListener httpSessionListener(){
        return new SessionListener();
    }

}