package com.example.Discovery_Rewards.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration //  a class  can declare one or more @Bean methods
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student Llewellyn = new Student( // id will automatically be generated by DB
                    "Llewellyn",
                    "llewellynant@hotmail.com",
                    LocalDate.of(1998,01,12),
                    23
            );
            Student Mariam = new Student(
                    "Mariam",
                    "mariam123@gmail.com",
                    LocalDate.of(2000,01,12),
                    21
            );
            studentRepository.saveAll(List.of(Llewellyn,Mariam)); // commits all students to database
        };
    }
}