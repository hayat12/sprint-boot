package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository){
    return args -> {
      Student hayat = new Student(
              "Hayat",
              "hayat@yahoo.com",
              LocalDate.of(1993, Month.APRIL, 18));
      Student yahya = new Student(
              "yahyah",
              "yaya@yahoo.com",
              LocalDate.of(1990, Month.APRIL, 28));
    repository.saveAll(List.of(hayat, yahya));
    };
  }
}
