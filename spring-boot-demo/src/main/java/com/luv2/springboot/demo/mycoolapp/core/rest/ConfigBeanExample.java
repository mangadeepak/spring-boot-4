package com.luv2.springboot.demo.mycoolapp.core.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2.springboot.demo.mycoolapp.core.domain.Coach;


@RestController 
public class ConfigBeanExample {

    private Coach tennisCoach;
    
    public ConfigBeanExample(@Qualifier("tennisCoach") Coach tennisCoach) {
        this.tennisCoach = tennisCoach;
    }

    @GetMapping("/configBeanExample")
    public String getMethodName() {
        return tennisCoach.getDailyWorkOut();
    }
    
}
