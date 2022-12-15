package com.backend.WebNewsBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebNewsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebNewsBackendApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/dashboard/get").allowedOrigins("http://44.211.174.87:3000");
//				registry.addMapping("/dashboard/get").allowedOrigins("http://172.31.88.251:3000");
//			}
//		};
//	}

}
