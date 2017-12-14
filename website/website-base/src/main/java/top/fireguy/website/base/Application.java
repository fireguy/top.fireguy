package top.fireguy.website.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import top.fireguy.website.base.controller.HelloworldController;


@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(HelloworldRestController.class, args);
		SpringApplication.run(HelloworldController.class, args);
	}

}
