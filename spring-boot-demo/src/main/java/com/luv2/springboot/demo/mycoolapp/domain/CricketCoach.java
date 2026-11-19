package com.luv2.springboot.demo.mycoolapp.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component 
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkOut() {
        return "Inside CricketCoach.getDailyWorkOut()";
    }
    
}
