package com.luv2.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.RestController;

import com.luv2.springboot.demo.mycoolapp.domain.Coach;
import com.luv2.springboot.demo.mycoolapp.domain.CricketCoach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class BeanScopeExample {

    private Coach cricketCoachOne;
    private Coach cricketCoachTwo;
    private Coach swimCoachOne;
    private Coach swimCoachTwo;

    @Autowired 
    public BeanScopeExample(Coach cricketCoachOne, Coach cricketCoachTwo, @Qualifier("swimCoach") Coach swimCoachOne, @Qualifier("swimCoach") Coach swimCoachTwo) {
        this.cricketCoachOne = cricketCoachOne;
        this.cricketCoachTwo = cricketCoachTwo;
        this.swimCoachOne = swimCoachOne;
        this.swimCoachTwo = swimCoachTwo;
    }


    @GetMapping("/beanScopeExample")
    public String beanScopeExample() {
        return "CricketCoachOne == CricketCoachTwo ? %s <BR> SwimCoachOne == SwimCoachTwo ? %s".formatted((cricketCoachOne == cricketCoachTwo)+"", (swimCoachOne == swimCoachTwo)+"");
    }
    

}
