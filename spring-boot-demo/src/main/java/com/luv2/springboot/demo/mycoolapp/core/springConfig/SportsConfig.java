package com.luv2.springboot.demo.mycoolapp.core.springConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luv2.springboot.demo.mycoolapp.core.domain.Coach;
import com.luv2.springboot.demo.mycoolapp.core.domain.TennisCoach;

@Configuration 
public class SportsConfig {

    @Bean("tennisCoach")
    public Coach tennisCoach() {
        return new TennisCoach();
    }

}
