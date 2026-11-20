package com.luv2.springboot.demo.mycoolapp.core.domain;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SwimCoach implements Coach{

    public SwimCoach() {
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
