package kz.moderntech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ModerntechApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModerntechApplication.class, args);
	}

}
