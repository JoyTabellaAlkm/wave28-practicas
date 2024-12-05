package ejercicios.deportista.controllers;

import ejercicios.deportista.dto.DeporteDTO;
import ejercicios.deportista.services.IDeporte;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {
    @Autowired
    private IDeporte deporte;


    @GetMapping("/findSports")
    public List<DeporteDTO> findSports(){
        return deporte.encontrarDeportes();
    }
}
