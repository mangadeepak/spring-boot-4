package com.luv2.springboot.demo.mycoolapp.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach  implements Coach{

    public BaseballCoach() {
        System.out.printf("In constructor: %s\n", this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Inside %s.getDailyWorkOut()".formatted(this.getClass().getSimpleName());
    }

}
