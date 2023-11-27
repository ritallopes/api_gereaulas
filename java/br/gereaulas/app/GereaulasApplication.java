package br.gereaulas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= "br.gereaulas")
@EntityScan("br.gereaulas")
@EnableJpaRepositories("br.gereaulas")
public class GereaulasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GereaulasApplication.class, args);
	}

}
