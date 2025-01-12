package ar.com.mercadolibre.mundial.controller;

import ar.com.mercadolibre.mundial.models.Jugador;
import ar.com.mercadolibre.mundial.services.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jugador")
public class JugadorController {
    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerJugadorPorId(@PathVariable int id) {
        return new ResponseEntity<>(jugadorService.obtenerJugadorPorId(id), HttpStatus.OK);
    }


}
