package br.com.cast.projetinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
/*
 * @EnableAutoConfiguration(exclude= { DataSourceAutoConfiguration.class,
 * HibernateJpaAutoConfiguration.class })
 */
public class ProjetinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetinhoApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configCors() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE",
						"CONNECT");
			}
		};
	}

}
