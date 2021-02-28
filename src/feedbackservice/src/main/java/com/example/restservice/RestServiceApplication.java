package com.example.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RestServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(FeedbackRepository repository) {
      return (args) -> {
        // save a few Feedbacks
        repository.save(new Feedback(1, "Feedback 1"));
        repository.save(new Feedback(2, "Feedback 2"));
        // fetch all Feedbacks
        log.info("Feedbacks found with findAll():");
        log.info("-------------------------------");
        for (Feedback Feedback : repository.findAll()) {
          log.info(Feedback.toString());
        }
        log.info("");

        // fetch an individual Feedback by ID
        Feedback Feedback = repository.findById(1L);
        log.info("Feedback found with findById(1L):");
        log.info("--------------------------------");
        log.info(Feedback.toString());
       
        log.info("");
      };
    }

}
