package ar.com.mercadolibre.mundial.controller;

import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerJugadorPorId(@PathVariable int id) {
        Jugador jugador = jugadorService.obtenerJugadorPorId(id);
        if (jugador != null) {
            return ResponseEntity.ok(jugador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Jugador>> obtenerJugadoresOrdenadosPorGoles() {
        List<Jugador> jugadores = jugadorService.obtenerJugadoresOrdenadosPorGoles();
        return ResponseEntity.ok(jugadores);
    }

    @PostMapping
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador) {
        Boolean created = jugadorService.save(jugador);
        if (created) {
            return ResponseEntity.status(HttpStatus.CREATED).body(jugador);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarJugador(@PathVariable int id, @RequestBody Jugador jugador) {
        jugador.setId(id);
        Boolean updated = jugadorService.update(jugador);
        if (updated) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable int id) {
        Jugador jugador = jugadorService.obtenerJugadorPorId(id);
        if (jugador != null) {
            jugadorService.delete(jugador);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}