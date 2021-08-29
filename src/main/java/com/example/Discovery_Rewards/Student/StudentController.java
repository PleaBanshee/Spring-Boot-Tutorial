// Class contains all API resources
package com.example.Discovery_Rewards.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController // Allows you to serve Restful endpoints
@RequestMapping(path="api/v1/student") // URL link to display students
public class StudentController {
    // bean types. Beans is a source of contextual objects that define application state and/or logic
    private final StudentService studentService; // this class is a Bean

    @Autowired // allows injections into methods
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // client requests data
    public List<Student> getStudents() {
        return studentService.getStudents(); // returns students from StudentsService Class
    }

    @PostMapping // used to send data to server
    public void registerStudent(@RequestBody Student student) { // RequestBody: data sent by the client to your API
        studentService.addNewStudent(student);
    }

    // test put method like this: api/v1/student/id?name=Elton&email=manofthe80s@gmail.com
    @PutMapping(path="{studentID}") // update a data entity
    public void updateStudent(
            // @RequestParam: extract query parameters, form parameters etc.
            @PathVariable("studentID") Long studentID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudents(studentID,name,email);
    }

    // @PathVariable: handle template variables in the request URI mapping, and set them as method parameters
    @DeleteMapping(path="{studentID}") // delete content from server
    public void deleteStudent(@PathVariable("studentID") Long studentID) {
        studentService.deleteStudent(studentID);
    }
}
