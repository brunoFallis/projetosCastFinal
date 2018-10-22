package br.com.cast.imdbApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
/*@EnableAutoConfiguration(exclude = {
		HibernateJpaAutoConfiguration.class,
		DataSourceAutoConfiguration.class
})*/
public class ImdbApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ImdbApiApplication.class, args);
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
