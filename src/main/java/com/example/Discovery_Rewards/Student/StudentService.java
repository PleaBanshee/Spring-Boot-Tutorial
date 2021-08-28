// Class containing business services
package com.example.Discovery_Rewards.Student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service // marks class as a service provider
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Llewellyn",
                        "llewellynant@hotmail.com",
                        LocalDate.of(1998,01,12),
                        23
                )
        );
    }
}
