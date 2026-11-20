package com.luv2.springboot.demo.mycoolapp.core.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2.springboot.demo.mycoolapp.core.domain.Coach;


@RestController 
public class SpringConstructorDependencyInjectionController {

    private Coach myCoach;

    //@Autowired
    //NOTE: Incase of single bean injection in constructor there is no need to add @AutoWired annotation.
    public SpringConstructorDependencyInjectionController(@Qualifier("cricketCoach") Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/constructorBasedDependencyInjection")
    public String getDailyWorkout() {
        return "Constructor based dependency injection: " + myCoach.getDailyWorkOut();
    }

}
