package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated // NECESITAMOS ESTA NOTACION CUANDO TENGAMOS VALIDACIONES EN LOS PARAMETROS DE LOS METODOS DE LOS CONTROLLER
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@RequestBody @Valid StudentDTO rq) {
        return service.analyzeScores(rq);
    }

    @PostMapping("/student")
    public StudentDTO createStudent(@RequestBody @Valid StudentDTO rq) { // @VALID PARA VALIDAR EL OBJETO StudentDTO
        return service.addStudent(rq);
    }

    @GetMapping("/students/{studentName}")
    public StudentDTO getStudent(@PathVariable
                                     @NotBlank(message = "El nombre del estudiante no puede estar vacío.")
                                     @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
                                     @Size(min = 5, message = "La longitud del nombre del estudiante no puede ser menor a 5 caracteres.")
                                     String studentName) { // NOTACIONES DE VALIDACIONES DELANTE DE CADA ATRIBUTO, SE SEPARAN POR ESPACIO
        return service.getName(studentName);
    }

    @GetMapping("/studentsPorRQParams")
    public StudentDTO getStudentRequestParams(@RequestParam
                                                @NotNull(message = "El nombre del estudiante no puede estar vacío.")
                                                @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
                                                @Size(min = 5, message = "La longitud del nombre del estudiante no puede ser menor a 5 caracteres.")
                                                String studentName) {
        return service.getNameRqParam(studentName);

    }


}
