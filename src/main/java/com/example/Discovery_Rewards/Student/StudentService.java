// Class containing business services
package com.example.Discovery_Rewards.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // marks class as a service provider
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // returns a list of students
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        // can have a value or null
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) { // if value exists
            throw new IllegalStateException("Email is already taken");
        } else {
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long studentID) {
        boolean exists = studentRepository.existsById(studentID);
        if (!exists) {
            throw new IllegalStateException(String.format("The selected student with ID %d doesn\'t exist",studentID));
        } else {
            studentRepository.deleteById(studentID);
        }
    }

    @Transactional // allows you to perform database transactions
    public void updateStudents(Long studentID, String name, String email) {
        Student student = studentRepository.findById(studentID).orElseThrow(() -> // checks whether student exist
                new IllegalStateException(String.format("The selected student with ID %d doesn\'t exist",studentID))
            );
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(),name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email is taken");
            } else {
                student.setEmail(email);
            }
        }
    }
}