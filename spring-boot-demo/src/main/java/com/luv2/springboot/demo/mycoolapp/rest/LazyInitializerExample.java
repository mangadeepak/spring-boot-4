package com.luv2.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class LazyInitializerExample {

    @GetMapping("/lazyInitialization")
    public String lazyInitializationExample() {
        return "As BadmintonCoach is not used anywhere hence bean is not initialized.";
    }

}
