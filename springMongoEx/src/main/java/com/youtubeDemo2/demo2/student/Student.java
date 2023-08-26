package com.youtubeDemo2.demo2.student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate date;
    @Transient // Transient basically means that the AGE field doesn't need to be a column in our database,
//    so age will be calculated for us
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Student(String name, String email, LocalDate date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAge() {
        return (Period.between(this.date, LocalDate.now()).getYears());
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
                ", date=" + date +
                ", age=" + age +
                '}';
    }
}
