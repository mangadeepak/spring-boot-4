package com.luv2.springboot.demo.mycoolapp.core.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy 
public class BadmintonCoach implements Coach{

    public BadmintonCoach() {
        System.out.printf("In constructor: %s\n", this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Inside %s.getDailyWorkOut()".formatted(this.getClass().getSimpleName());
    }

}
