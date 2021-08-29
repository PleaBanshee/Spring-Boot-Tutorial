package com.example.Discovery_Rewards.Student;

import javax.persistence.*; // allows you to change providers while keeping implementations persistent
import java.time.LocalDate;
import java.time.Period;

@Entity // allows a class can be mapped to a table
@Table // allows you to specify the details of the table that will be used to persist the entity in the database
public class Student {
    @Id
    @SequenceGenerator(name="student_seq",sequenceName="student_seq",allocationSize = 1) // allocationSize: increment by 1
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient // ignore a field to not persist in database
    private Integer age;

    public Student() {

    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) { // constructor for db creation of students
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    // returns current age
    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
