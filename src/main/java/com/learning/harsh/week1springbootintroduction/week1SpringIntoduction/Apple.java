package com.learning.harsh.week1springbootintroduction.week1SpringIntoduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Apple {
    void eatApple(){
        System.out.println("I am eating apple");
    }

    @PostConstruct
    void beforeApple(){
        System.out.println("Before apple is used");
    }

    @PreDestroy
    void Destroy(){
        System.out.println("Apple is going");
    }
}
