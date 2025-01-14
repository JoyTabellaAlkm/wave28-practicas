package com.example.ejemplo_jpa.controller;

import com.example.ejemplo_jpa.model.Student;
import com.example.ejemplo_jpa.service.IStudentService;
import com.example.ejemplo_jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        iStudentService.saveStudent(student);
        return "El estudiante fue creado exitosamente";
    }
    @GetMapping("/student/{id}")
    public Student findStudent(@PathVariable Long id){
        return iStudentService.findStudent(id);
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return iStudentService.getStudents();
    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id){
        iStudentService.deleteStudent(id);
        return "El estudiante fue eliminado exitosamente";
    }
   @PutMapping("student/{id}")
   public String updateStudent(@PathVariable Long id, @RequestBody Student student){
        iStudentService.updateStudent(id, student);
        return "El estudiante fue actualizado exitosamente";
   }
}
