package com.dario.dominguez.practicaentradablog.controller;

import com.dario.dominguez.practicaentradablog.dto.EntradaBlogDto;
import com.dario.dominguez.practicaentradablog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/post")
    public ResponseEntity<?> agregarNuevoPost(@RequestBody EntradaBlogDto entradaBlogDto){
        Long id = blogService.agregarNuevoBlog(entradaBlogDto);
        return ResponseEntity.status(HttpStatus.OK).body("Se agrego correctamente un nuevo blog con el id: " + id);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<EntradaBlogDto> buscarPorId (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(blogService.encontrarPorId(id));
    }

    public ResponseEntity<List<EntradaBlogDto>> buscarTodos (){
        return ResponseEntity.status(HttpStatus.OK).body(blogService.buscarTodos());
    }
}
