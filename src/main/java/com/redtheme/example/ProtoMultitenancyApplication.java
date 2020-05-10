package com.redtheme.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@SpringBootApplication
@ImportResource(locations = {"classpath:/applicationContext.xml"})
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class, FlywayAutoConfiguration.class})
public class ProtoMultitenancyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtoMultitenancyApplication.class, args);
	}

}
