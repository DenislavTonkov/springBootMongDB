package com.youtubeDemo2.demo2.student;

import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    //Constructor
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken Mate!");
        }
        studentRepository.save(student);
    }


    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

//    public void updateStudent(Long studentId) {
//        boolean exists = studentRepository.existsById(studentId);
////        if (!exists) {
////            throw new NoSuchElementException("User with id " + studentId + " does not exist");
////        }
//        Student existingStudent = studentRepository.findById(studentId).orElseThrow(() ->
//                new NoSuchElementException("User with id " + studentId + " does not exist"));
//
//        System.out.println(" ================!!!!!!!!!!!!!================ " +
//                existingStudent +
//                " ================!!!!!!!!!!!!!================ ");
//
//        existingStudent.setName();
//    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchElementException("User with id " + studentId + " does not exist"));

        System.out.println(" ================!!!!!!!!!!!!!================ " +
                existingStudent +
                " ================!!!!!!!!!!!!!================ ");

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(existingStudent.getName(), name)) {
            existingStudent.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(existingStudent.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email TAKEN!");
            }
            existingStudent.setEmail(email);
        }
    }
}
