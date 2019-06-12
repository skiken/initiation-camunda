package tn.insat.eservices.tp2.HelloworldCamunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class HelloworldCamundaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldCamundaApplication.class, args);
	}

}
