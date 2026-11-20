package com.luv2.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.RestController;

import com.luv2.springboot.demo.mycoolapp.domain.Coach;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
