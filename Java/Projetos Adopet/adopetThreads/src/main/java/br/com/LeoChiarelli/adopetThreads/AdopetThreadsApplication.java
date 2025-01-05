package br.com.LeoChiarelli.adopetThreads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // Indicando para o spring que nesta aplicacao, eu vou criar threads separadas
public class AdopetThreadsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopetThreadsApplication.class, args);
	}

}
