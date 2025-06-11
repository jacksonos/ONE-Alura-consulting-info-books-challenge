package com.alura.bookchallenge;

import com.alura.bookchallenge.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookChallengeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.showMenu();
	}
}
