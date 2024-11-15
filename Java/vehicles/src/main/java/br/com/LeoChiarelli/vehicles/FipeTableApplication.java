package br.com.LeoChiarelli.vehicles;

import br.com.LeoChiarelli.vehicles.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeTableApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeTableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.displayMenu();
	}
}
