package org.obras.cotroller;

import org.obras.model.Obra;
import org.obras.service.iObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObraController {

    @Autowired
    private iObraService service;

    @GetMapping("/findAnio")
    public ResponseEntity<List<Obra>> getAnio(@RequestParam String anio) {
        return new ResponseEntity<>(service.findByAnio(anio), HttpStatus.OK);
    }

    @GetMapping("/findAutor")
    public ResponseEntity<List<Obra>> getAutor(@RequestParam String autor) {
        return new ResponseEntity<>(service.findByAutorContaining(autor), HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<List<Obra>> getTop5() {
        return new ResponseEntity<>(service.findTop5ByOrderByPaginasDesc(), HttpStatus.OK);
    }
}
