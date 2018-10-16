package br.com.cast.climinha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude= {
		HibernateJpaAutoConfiguration.class,
		DataSourceAutoConfiguration.class
})
public class CliminhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CliminhaApplication.class, args);
	}
}
