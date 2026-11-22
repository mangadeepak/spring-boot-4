package com.luv2.springboot.demo.mycoolapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2.springboot.demo.mycoolapp.hibernateExample.service.HibernateExampleRunner;

@SpringBootApplication(scanBasePackages = {
	"com.luv2.springboot.demo.mycoolapp",
})
public class MycoolappApplication {

	@Autowired 
	public HibernateExampleRunner hibernateExampleRunner;

	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}

	@Bean 
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			System.out.println("Hello World!!!");
			//hibernateExampleRunner.runStudentDaoImpl("deleteAll", null, 1, "Neil", null, null);
		};
	}

}
