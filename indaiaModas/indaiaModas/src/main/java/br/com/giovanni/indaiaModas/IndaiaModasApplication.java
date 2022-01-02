package br.com.giovanni.indaiaModas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.giovanni.indaiaModas"})//mais simplificado ja englobando tudo
@EnableAsync
public class IndaiaModasApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndaiaModasApplication.class, args);
	}

}
