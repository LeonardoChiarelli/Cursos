package br.com.LeoChiarelli.screenSoundSpring;

import br.com.LeoChiarelli.screenSoundSpring.main.Main;
import br.com.LeoChiarelli.screenSoundSpring.repository.IArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenSoundApplication implements CommandLineRunner {

	@Autowired
	private IArtistRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ScreenSoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repository);
		main.displayMenu();
	}
}
