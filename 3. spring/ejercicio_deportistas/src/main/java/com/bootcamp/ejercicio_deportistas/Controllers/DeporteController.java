package com.bootcamp.ejercicio_deportistas.Controllers;

import com.bootcamp.ejercicio_deportistas.Dto.DeporteDto;
import com.bootcamp.ejercicio_deportistas.Services.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deporte")
public class DeporteController {
    @Autowired
    private IDeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<?> buscarDeporte() {
        List<DeporteDto> deportes = deporteService.buscarDeportes();

        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> buscarNivelPorNombre(@PathVariable String name) {
        String level = deporteService.buscarNivelPorNombre(name);

        if (level == null)
            return new ResponseEntity<>(
                    "No existe un deporte con ese nombre",
                    HttpStatus.BAD_REQUEST
            );

        return new ResponseEntity<>(level, HttpStatus.OK);
    }
}
