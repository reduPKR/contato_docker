package br.com.contato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ContatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContatoApplication.class, args);
	}

}
