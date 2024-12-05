package ejercicios.deportista.controllers;

import ejercicios.deportista.dto.DeporteDTO;
import ejercicios.deportista.dto.responses.DeportesYPersonasResponse;
import ejercicios.deportista.services.IDeporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deporte")
public class DeporteController {

    @Autowired
    private IDeporte deporte;


    @GetMapping("/findSports")
    public List<DeporteDTO> findSports(){
        return deporte.listaDeportes();
    }

    @GetMapping("/findSport")
    public ResponseEntity<DeporteDTO> findSportByName(@RequestParam String nombre){

        return new ResponseEntity<DeporteDTO>(deporte.encontrarDeporte(nombre),HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSportsPeople")
    public ResponseEntity<?> findSportsPeople(){
        return new ResponseEntity<List<DeportesYPersonasResponse>>(deporte.encontrarDeportesPersonas(),HttpStatus.ACCEPTED);
    }
}
