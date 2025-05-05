/* package br.com.LeoChiarelli;

import br.com.LeoChiarelli.main.Main;
import br.com.LeoChiarelli.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SreenMatchApplicationWithoutWeb implements CommandLineRunner {
	@Autowired
	private SerieRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SreenMatchApplicationWithoutWeb.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main principal = new Main(repository);
		principal.displayMenu();
	}
}
*/