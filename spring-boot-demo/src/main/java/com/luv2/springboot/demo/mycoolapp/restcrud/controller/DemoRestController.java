package com.luv2.springboot.demo.mycoolapp.restcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping ("/demo")
public class DemoRestController {

    @GetMapping("/helloWorld")
    public String getMethodName() {
        return "Hello World!!!";
    }
    

}
