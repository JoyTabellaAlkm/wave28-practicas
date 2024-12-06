package com.example.demo.Controller;

import com.example.demo.Model.Personaje;
import com.example.demo.Repository.PersonajesRepository;
import com.example.demo.Service.iPersonajeService;
import org.springframework.aop.support.DelegatePerTargetObjectIntroductionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajesController {

    @Autowired
    PersonajesRepository personajesRepository;

    @Autowired
    iPersonajeService personajeService;

    @GetMapping("/")
    public List<Personaje> get() {
        return personajesRepository.imprimir();
    }

    @GetMapping("/nombre/{name}")
    public ResponseEntity<java.lang.String> buscarPorNombre(@PathVariable String name) {

        return ResponseEntity.ok(personajesRepository.findByName(name));
    }
}
