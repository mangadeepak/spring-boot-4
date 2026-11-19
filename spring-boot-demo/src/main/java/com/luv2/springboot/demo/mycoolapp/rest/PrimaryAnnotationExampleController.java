package com.luv2.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2.springboot.demo.mycoolapp.domain.Coach;

@RestController
public class PrimaryAnnotationExampleController {

    private Coach myCoach;

    //@Autowired is not required as there is only one argument in constructor
    public PrimaryAnnotationExampleController(Coach theCoach) {
        this.myCoach = theCoach;
    }

    @GetMapping("/primaryAnnotationBeanInjection")
    public String generateDataFromPrimaryAnnotationBean() {
        return myCoach.getDailyWorkOut();
    }
}
