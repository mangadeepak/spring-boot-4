package com.luv2.springboot.demo.mycoolapp.springConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2.springboot.demo.mycoolapp.domain.Coach;
import com.luv2.springboot.demo.mycoolapp.domain.TennisCoach;

@Configuration 
public class SportsConfig {

    @Bean("tennisCoach")
    public Coach tennisCoach() {
        return new TennisCoach();
    }

}
