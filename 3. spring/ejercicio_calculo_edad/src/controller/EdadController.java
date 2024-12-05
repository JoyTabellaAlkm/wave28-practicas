package controller;
import com.example.Ejercicios_EdadPersonas.Service.EdadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;

@RestController
@RequestMapping("/Edad")
public class EdadController {
    @Autowired
    private EdadService service;

    @GetMapping("{dia}/{mes}/{anio}")
    public ResponseEntity<String> getEdad (@PathVariable int dia, @PathVariable int mes, @PathVariable int anio ){
        try{
            return ResponseEntity.ok().body(service.calcularEdad(dia, mes, anio));
        }catch (DateTimeException e){
            return ResponseEntity.badRequest().body("Ha habido un problema con los datos ingresados");
        }
    }

}