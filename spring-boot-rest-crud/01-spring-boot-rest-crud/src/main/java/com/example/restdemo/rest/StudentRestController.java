package com.example.restdemo.rest;

import com.example.restdemo.entity.Student;
import com.example.restdemo.entity.StudentErrorResponse;
import com.example.restdemo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.loader.ResourceEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> listOfStudent;

    /*
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
        //create student error response

        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler ResponseEntity<StudentErrorResponse> handleException(Exception ex){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }

     */

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
        if(studentId>=listOfStudent.size() || studentId<0){
            throw new StudentNotFoundException("Student not found exception id :: "+ studentId);
        }
        return  listOfStudent.get(studentId);
    }
}
