package com.vinigomes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vinigomes.design.App;



@SpringBootApplication
public class SpringBootTeste2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTeste2Application.class, args);
		App.main(args);
	}

}
