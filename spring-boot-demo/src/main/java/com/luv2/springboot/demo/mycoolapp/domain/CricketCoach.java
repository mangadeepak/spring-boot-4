package com.luv2.springboot.demo.mycoolapp.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Primary
@Component 
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.printf("In constructor: %s\n", this.getClass().getSimpleName());
    }

    @PostConstruct  
    public void postConstruct() {
        System.out.println("Just after created bean %s".formatted(this.getClass().getSimpleName()));
    }

    @PreDestroy 
    public void preDestroy() {
        System.out.println("About to destroy %s".formatted(this.getClass().getSimpleName()));
    }

    @Override
    public String getDailyWorkOut() {
        return "Inside %s.getDailyWorkOut()".formatted(this.getClass().getSimpleName());
    }
    
}
