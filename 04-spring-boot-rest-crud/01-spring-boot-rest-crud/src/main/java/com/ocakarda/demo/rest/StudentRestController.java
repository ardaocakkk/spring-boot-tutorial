package com.ocakarda.demo.rest;

import com.ocakarda.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //define @PostConstructor to load the students data ... only once

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        Student student1 = new Student("arda", "ocak");
        Student student2 = new Student("eren", "ozcan");

        theStudents.add(student1);
        theStudents.add(student2);

    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getOneStudent(@PathVariable int studentId) {

        if(studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found : " + studentId);
        }
        return theStudents.get(studentId);

    }



}
