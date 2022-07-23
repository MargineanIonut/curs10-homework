package org.fasttrackit.curs10.homework;

import org.fasttrackit.curs10.homework.model.Location;
import org.fasttrackit.curs10.homework.model.entities.Train;
import org.fasttrackit.curs10.homework.model.mappers.TrainMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Curs10HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(Curs10HomeworkApplication.class, args);
	}

	@Bean
	CommandLineRunner forTest(TrainMapper mapper){
		return args -> {
			System.out.println(mapper.toEntity(new Train("model12",12,new Location("123","123"))));
		};
	}
}
