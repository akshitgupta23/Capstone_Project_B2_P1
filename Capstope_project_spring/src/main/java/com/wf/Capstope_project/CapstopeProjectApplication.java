package com.wf.Capstope_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("*")
public class CapstopeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapstopeProjectApplication.class, args);
	}

}
