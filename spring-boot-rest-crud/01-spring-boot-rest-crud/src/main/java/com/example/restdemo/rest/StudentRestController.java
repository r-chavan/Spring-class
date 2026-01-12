package com.example.restdemo.rest;

import com.example.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> listOfStudent;

    @PostConstruct
    private void getStudents() {
        listOfStudent = new ArrayList<>();
        listOfStudent.add(new Student(1, "Rahul", "Chavan"));
        listOfStudent.add(new Student(2, "Shardul", "Nimbalkar"));
        listOfStudent.add(new Student(3, "Sujit", "Kumar"));
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return  listOfStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        return  listOfStudent.get(studentId);
    }
}
