package br.com.LeoChiarelli;

import br.com.LeoChiarelli.main.Main;
import br.com.LeoChiarelli.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SreenMatchApplication {
	public static void main(String[] args) {
		SpringApplication.run(SreenMatchApplication.class, args);
	}
}
