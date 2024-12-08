package com.example.deportistas.controller;


import com.example.deportistas.service.IPersonService;
import com.example.deportistas.service.ISportService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportController {

    @Autowired
    ISportService sportService;
    @Autowired
    IPersonService personService;

    @GetMapping("/find_sports")
    public ResponseEntity<?> findSports() {
        return new ResponseEntity<>(sportService.getSports(), HttpStatus.OK);
    }

    @GetMapping("/find_sport/{name}")
    public ResponseEntity<?> findSport(@PathVariable String name) {
        try{
            return new ResponseEntity<>(sportService.getSportByName(name), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getpeople")
    public ResponseEntity<?> getPeople() {
        return new ResponseEntity<>(personService.getListPeople(), HttpStatus.OK);
    }

}
