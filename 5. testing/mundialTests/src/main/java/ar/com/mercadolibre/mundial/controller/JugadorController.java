package ar.com.mercadolibre.mundial.controller;

import ar.com.mercadolibre.mundial.dto.RequestJugadorDTO;
import ar.com.mercadolibre.mundial.dto.ResponseDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.services.JugadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JugadorController {
    @Autowired
    JugadorService jugadorService;

    @GetMapping("/jugadores")
    public ResponseEntity<List<Jugador>> getAll() {
        return new ResponseEntity<>(jugadorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/jugadores/{id}")
    public ResponseEntity<Jugador> show(@PathVariable int id) {
        return new ResponseEntity<>(jugadorService.show(id), HttpStatus.OK);
    }

    @PostMapping("/jugadores")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody RequestJugadorDTO requestJugador) {
        return new ResponseEntity<>(jugadorService.create(requestJugador), HttpStatus.CREATED);
    }

    @PutMapping("/jugadores/{id}")
    public ResponseEntity<Jugador> update(@Valid @RequestBody RequestJugadorDTO requestJugador,
                                          @PathVariable int id) {
        return new ResponseEntity<>(jugadorService.update(id, requestJugador), HttpStatus.OK);
    }

    @DeleteMapping("/jugadores/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int id) {
        return new ResponseEntity<>(jugadorService.delete(id), HttpStatus.OK);
    }
}
