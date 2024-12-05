package com.example.calcularedad.controller;

import com.example.calcularedad.service.CalcularEdadService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.String.format;
import static java.lang.String.join;

@RestController
public class CalcularEdadController {

    private CalcularEdadService calcularEdadService = new CalcularEdadService();

    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer updateCaseFollowup(@PathVariable
                                      String dia,@PathVariable String mes,@PathVariable String anio){

        return calcularEdadService.formatear(dia, mes, anio);


    }
}
