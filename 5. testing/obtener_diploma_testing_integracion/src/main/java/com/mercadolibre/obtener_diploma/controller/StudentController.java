package com.mercadolibre.obtener_diploma.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.obtener_diploma.model.StudentDTO;
import com.mercadolibre.obtener_diploma.service.IStudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/registerStudent")
    public ResponseEntity<?> registerStudent(@RequestBody @Valid StudentDTO stu) {
        this.studentService.create(stu);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return this.studentService.read(id);
    }

    @PostMapping("/modifyStudent")
    public ResponseEntity<?> modifyStudent(@RequestBody @Valid StudentDTO stu) {
        this.studentService.update(stu);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/removeStudent/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Long id) {
        this.studentService.delete(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/listStudents")
    public Set<StudentDTO> listStudents() {
        return this.studentService.getAll();
    }

}
