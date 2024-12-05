package com.demo.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class HelloRestController {
    @GetMapping("/{employeeId}")
    public String saludarUsuario(
            @PathVariable("employeeId") Integer employeeId,
            @RequestParam("name") String name
    ) {
        return "Saludo: " + name + " con ID: " + employeeId;
    }
}