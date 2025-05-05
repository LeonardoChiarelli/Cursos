package br.com.LeoChiarelli.adopetThreads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync // Indicando para o spring que nesta aplicação, eu vou criar threads separadas
@EnableScheduling // Indicando para o spring que nesta aplicação, o agendamento de tarefas é permitido
public class AdopetThreadsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdopetThreadsApplication.class, args);
	}

}
