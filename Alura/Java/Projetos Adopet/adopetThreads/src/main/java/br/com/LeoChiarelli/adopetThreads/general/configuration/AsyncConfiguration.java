package br.com.LeoChiarelli.adopetThreads.general.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfiguration {

    @Bean // usado para sinalizar que um metodo de uma classe Spring Configuration deve ser tratado como um bean gerenciado pelo contêiner do Spring
    public Executor asyncExecutor(){

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3); // Mínimo de threads que vão ser criadas
        executor.setMaxPoolSize(3); // Máximo de threads que vão ser criadas
        executor.setQueueCapacity(100); // Capacidade máxima da fila de threads
        executor.setThreadNamePrefix("AsyncThread-"); // "prefixo fixo" da thread
        executor.initialize(); // inicializando o executor
        return executor;
    }
}

// Executor - interface do pacote concurrent (pacote relacionado à concorrência do Java) que fala como vamos executar nossas threads
