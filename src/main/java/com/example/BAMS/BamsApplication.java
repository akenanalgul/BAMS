package com.example.BAMS;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.BAMS.model")
@EnableJpaRepositories(basePackages = "com.example.BAMS.repository")
public class BamsApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();

		System.setProperty("DB_USERNAME",dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD",dotenv.get("DB_PASSWORD"));
		System.setProperty("DB_URL",dotenv.get("DB_URL"));


		SpringApplication.run(BamsApplication.class, args);
	}

}
