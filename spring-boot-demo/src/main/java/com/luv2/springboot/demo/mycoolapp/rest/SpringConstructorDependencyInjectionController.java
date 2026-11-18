package com.luv2.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2.springboot.demo.mycoolapp.domain.Coach;


@RestController 
public class SpringConstructorDependencyInjectionController {

    private Coach myCoach;

    @Autowired
    public SpringConstructorDependencyInjectionController(@Qualifier("cricketCoach") Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/constructorBasedDependencyInjection")
    public String getDailyWorkout() {
        return "Constructor based dependency injection: " + myCoach.getDailyWorkOut();
    }

}
