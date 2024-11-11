package br.com.LeoChiarelli;

import br.com.LeoChiarelli.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SreenMatchApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main principal = new Main();
		principal.displayMenu();
	}
}
