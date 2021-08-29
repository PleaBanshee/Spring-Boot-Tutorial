// Interface for data access
package com.example.Discovery_Rewards.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> { // interface extends a generic type: <object,type(ID)>

    // declares finder queries directly on repository methods. Student refers to student entity in student class
    @Query("SELECT s FROM Student s WHERE s.email LIKE ?1")
    Optional<Student> findStudentByEmail(String email); // may or may not contain a value
}
