package com.youtubeDemo2.demo2.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2023, AUGUST, 10)
            );

            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, APRIL, 5)
            );

            Student matt = new Student(
                    "Matt",
                    "matt@gmail.com",
                    LocalDate.of(1999, AUGUST, 31)
            );

            repository.saveAll(
                    List.of(mariam,alex,matt)
            );
        };
    }
}
