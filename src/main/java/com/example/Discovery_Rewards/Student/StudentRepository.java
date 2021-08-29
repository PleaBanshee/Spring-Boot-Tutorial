// Interface for data access
package com.example.Discovery_Rewards.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> { // interface extends a generic type: <object,type(ID)>

}
