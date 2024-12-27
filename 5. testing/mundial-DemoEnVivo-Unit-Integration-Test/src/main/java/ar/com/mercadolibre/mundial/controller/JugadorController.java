package ar.com.mercadolibre.mundial.controller;

import ar.com.mercadolibre.mundial.dto.JugadorDTO;
import ar.com.mercadolibre.mundial.dto.MensajeDTO;
import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping("/jugador/{id}")
    public ResponseEntity<JugadorDTO> obtenerJugadorPorId(@PathVariable int id) {
        return new ResponseEntity<>(jugadorService.obtenerJugadorPorId(id), HttpStatus.OK);
    }

    @GetMapping("/jugador")
    public ResponseEntity<JugadorDTO> obtenerJugadorPorNombre(@RequestParam String nombre) {
        return new ResponseEntity<>(jugadorService.obtenerJugadorPorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/jugadores")
    public ResponseEntity<List<JugadorDTO>> obtenerJugadoresOrdenadosPorGoles() {
        return new ResponseEntity<>(jugadorService.obtenerJugadoresOrdenadosPorGoles(), HttpStatus.OK);
    }

    @PostMapping("/jugador")
    public ResponseEntity<MensajeDTO> registrarJugador(@RequestBody JugadorDTO jugadorDTO) {
        return new ResponseEntity<>(jugadorService.registrarJugador(jugadorDTO), HttpStatus.CREATED);
    }

}
