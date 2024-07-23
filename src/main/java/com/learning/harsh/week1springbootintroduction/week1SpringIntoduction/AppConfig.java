package com.learning.harsh.week1springbootintroduction.week1SpringIntoduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton")
    Apple getApple(){
        return new Apple();
    }
}
