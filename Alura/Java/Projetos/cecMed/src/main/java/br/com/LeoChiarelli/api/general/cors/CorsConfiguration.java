package br.com.LeoChiarelli.api.general.cors;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5501")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS", "TRACE", "CONNECT");
    }
}
