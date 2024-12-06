package com.example.covid.Controller;

import com.example.covid.DTO.SintomaDTO;
import com.example.covid.Model.Sintoma;
import com.example.covid.Service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sintomas")
public class SintomaController {
    private final SintomaService sintomaService;
    @Autowired
    public SintomaController(SintomaService sintomaService){
        this.sintomaService = sintomaService;
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<Integer> obtenerSintoma(@PathVariable String nombre) {
        Sintoma sintoma = sintomaService.obtenerXNombre(nombre);
        if (sintoma == null) {
            return ResponseEntity.notFound().build();
        }
        SintomaDTO sintomaDTO = new SintomaDTO(sintoma.getNivelDeGravedad());
        return ResponseEntity.ok(sintomaDTO.getNivelDeGravedad());
    }

    @GetMapping ("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> obtenerAllSintomas(){
        List<Sintoma> listaSintomas = sintomaService.obtenerTodos();
        List<SintomaDTO> listaSintomasDTO = new ArrayList<>();
        for(Sintoma sintoma : listaSintomas){
            listaSintomasDTO.add(new SintomaDTO(sintoma.getNivelDeGravedad(),sintoma.getNombre()));
        }
        return ResponseEntity.ok(listaSintomasDTO);
    }

    @PostMapping("/crearSintoma")
    void crearSintoma(@RequestBody Sintoma sintoma){
        sintomaService.crear(sintoma);
        System.out.println("Sintoma creado exitosamente");
    }

}
