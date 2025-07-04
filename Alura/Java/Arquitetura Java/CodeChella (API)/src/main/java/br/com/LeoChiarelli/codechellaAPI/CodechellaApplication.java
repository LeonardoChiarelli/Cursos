package br.com.LeoChiarelli.codechellaAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CodechellaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodechellaApplication.class, args);
	}

}
