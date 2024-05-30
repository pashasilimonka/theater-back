package edu.sylymonka.theater;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TheaterApplication {


	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().directory("./").load();
        System.setProperty("SQL_DATABASE", dotenv.get("SQL_DATABASE"));
        System.setProperty("SQL_DATASOURCE", dotenv.get("SQL_DATASOURCE"));
        System.setProperty("SQL_USERNAME", dotenv.get("SQL_USERNAME"));
        System.setProperty("SQL_PASSWORD", dotenv.get("SQL_PASSWORD"));
		SpringApplication.run(TheaterApplication.class, args);
	}

}
