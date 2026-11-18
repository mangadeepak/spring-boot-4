package com.luv2.springboot.demo.mycoolapp.domain;

import org.springframework.stereotype.Component;

@Component 
public class BaseballCoach  implements Coach{

    @Override
    public String getDailyWorkOut() {
        return "Inside BaseballCoach.getDailyWorkOut()";
    }

}
