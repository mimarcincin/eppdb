package sk.upjs.eppdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EppdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EppdbApplication.class, args);

	}

}
