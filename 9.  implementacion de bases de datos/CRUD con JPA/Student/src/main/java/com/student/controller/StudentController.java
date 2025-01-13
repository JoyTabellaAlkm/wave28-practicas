package com.student.controller;

import com.student.dto.StudentDTO;
import com.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO student) {
        return new ResponseEntity<StudentDTO>(studentService.saveStudent(student), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return new ResponseEntity<List<StudentDTO>>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") int id) {
        return new ResponseEntity<StudentDTO>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<StudentDTO> editStudent(@PathVariable("id") int id, @RequestBody StudentDTO student) {
        return new ResponseEntity<StudentDTO>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }
}
