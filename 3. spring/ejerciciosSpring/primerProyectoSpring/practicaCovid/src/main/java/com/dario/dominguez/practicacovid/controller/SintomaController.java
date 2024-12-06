package com.dario.dominguez.practicacovid.controller;

import com.dario.dominguez.practicacovid.dto.SintomaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {

    public ResponseEntity<List<SintomaDto>> traerTodosSintomas (){
        return ResponseEntity.status(HttpStatus.OK).body();
    }
}
