package co.mercadolibre.deportistas.controller;

import co.mercadolibre.deportistas.service.IDeporteService;
import co.mercadolibre.deportistas.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeporteController {

    @Autowired
    IDeporteService ds;
    @Autowired
    IPersonaService ps;

    @GetMapping("/findSports")
    public ResponseEntity<?> findSports(){
        return new ResponseEntity<>(ds.consultaDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSports(@PathVariable String name){
        try{
            return new ResponseEntity<>(ds.consultaPorNombre(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> findPeople(){
        return new ResponseEntity<>(ps.listarPersonas(), HttpStatus.OK);
    }
}
