// Class contains all API resources
package com.example.Discovery_Rewards.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController // Allows you to serve Restful endpoints
@RequestMapping(path="api/v1/student") // URL link to display students
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // Default endpoint
    public List<Student> getStudents() {
        return studentService.getStudents(); // returns students from StudentsService Class
    }
}