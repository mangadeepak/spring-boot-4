package com.luv2.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class FunRestController {

    @Value("${application.welcome.message}")
    private String appWelcomeMessage;

    @GetMapping("/")
    public String displayWelcomeMessage() {
        return
            new StringBuilder(appWelcomeMessage)
                .append("<BR>- Basic overview.")
                .append("<BR>- Dev tools jar Demo - It helps in deploying the changed code by restarting server automatically.")
                .append("<BR>- Actuator jar demo - It helps in checking the health of application. Apart from /health endpoint incase other information are required from Actuator then this needs to be configured in application.properties file.")
                .append("<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * Added Spring boot starter security added for Actuator. - User is user and password is displayed on console. To add custom user credentials check application.properties.")
                .append("<BR>- @Value Annotation: Demo how to load properties from application.properties file. Kindly check global variable of FunRestController.")
                .append("<BR>- Dependency Injection and AutoWire examples")
                .append("<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * For constructor based injection refer SpringConstructorDependencyInjectionController")
                .append("<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; * For setter based injection refer SpringSetterDependencyInjectionController")
                .append("<BR>- @Qualifier examples - Refer class mentioned in examples of ConstructorBased and SetterBased injection.")
                .append("<BR>- @Primary examples - PrimaryAnnotationExampleController - Incase of multiple beans of same type if there is no @Qualifier present then bean with @Primary annotation will only be injected.")
                .toString();
    }
    
    @GetMapping("/devtoolsdemo")
    public String devToolsJarDemo() {
        return "Demo for devtools dependency in main pom  - It helps in deploying the changed code by restarting server automatically.";
    }
    
}
