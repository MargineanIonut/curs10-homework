package org.fasttrackit.curs10.homework;

import org.fasttrackit.curs10.homework.model.entities.LocationEntity;
import org.fasttrackit.curs10.homework.model.entities.TrainEntity;
import org.fasttrackit.curs10.homework.model.mappers.TrainMapper;
import org.fasttrackit.curs10.homework.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class Curs10HomeworkApplication {

	public static void main(java.lang.String[] args) {
		SpringApplication.run(Curs10HomeworkApplication.class, args);
	}
	@Autowired
	TrainRepository repository;
	@Bean
	CommandLineRunner forTest(TrainMapper mapper){
		return args -> {
			repository.save(new TrainEntity(UUID.randomUUID().toString(),"text",21,new LocationEntity(UUID.randomUUID().toString(),"Gherla")));
		};
	}
}
