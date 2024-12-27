package ar.com.mercadolibre.mundial.controller;

import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {
    @Autowired
    JugadorService jugadorService;

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerJugador(@PathVariable("id") int id) {
        return ResponseEntity.ok(jugadorService.obtenerJugadorPorId(id));
    }

    @GetMapping("/jugadores")
    public ResponseEntity<List<Jugador>> obtenerJugadores() {
        return ResponseEntity.ok(jugadorService.obtenerJugadores());
    }

    @PostMapping("")
    public ResponseEntity<Boolean> post(@RequestBody Jugador jugador) {
        return ResponseEntity.ok(jugadorService.crearJugador(jugador));
    }

    @PutMapping("")
    public ResponseEntity<Boolean> put(@RequestBody Jugador jugador) {
        return ResponseEntity.ok(jugadorService.crearJugador(jugador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(jugadorService.borrarJugador(id));
    }
}
