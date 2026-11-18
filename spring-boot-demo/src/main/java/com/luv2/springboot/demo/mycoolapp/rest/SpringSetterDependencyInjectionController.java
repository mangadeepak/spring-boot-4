package com.luv2.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2.springboot.demo.mycoolapp.domain.Coach;

@RestController 
public class SpringSetterDependencyInjectionController {

    private Coach myCoach;

    @Autowired 
    public void setCoach(@Qualifier("baseballCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }

    @GetMapping("/setterBasedDependencyInjection")
    public String getDailyWorkout() {
        return "Setter based dependency injection: " + myCoach.getDailyWorkOut();
    }

}
