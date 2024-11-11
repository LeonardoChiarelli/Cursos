package br.com.LeoChiarelli;

import br.com.LeoChiarelli.models.SeriesData;
import br.com.LeoChiarelli.service.APIconsumption;
import br.com.LeoChiarelli.service.ConvertsData;
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

		// CONSUMO DA API
		var consumoAPI = new APIconsumption();
		var json = consumoAPI.getData("http://www.omdbapi.com/?t=gilmore+girls&apikey=7c66c456");
		System.out.println(json);

		// INSTANCIAÇÃO DO CONVERSOR GSON - fizemos a implementação direto no 'pom.xml' pois estamos usando o Maven
		var conversor = new ConvertsData();
		SeriesData dados = conversor.getData(json, SeriesData.class);
		System.out.println(dados);
	}
}
