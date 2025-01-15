package org.showroom.controller;

import org.showroom.entity.Ropa;
import org.showroom.service.iShowroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShowroomController {

    @Autowired
    private iShowroomService service;

    @PostMapping("/postClothes")
    public ResponseEntity<Void> postClothes(@RequestBody Ropa ropa) {
        service.postClothe(ropa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getClothes")
    public ResponseEntity<List<Ropa>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/clothe/{code}")
    public ResponseEntity<Ropa> getClothe(@PathVariable int code) {
        return new ResponseEntity<>(service.getEspecificClothe(code), HttpStatus.OK);
    }

    @PutMapping("/putClothes/{code}")
    public ResponseEntity<Ropa> putClothe(@PathVariable int code, @RequestBody Ropa r) {
        return new ResponseEntity<>(service.updateClothe(code, r), HttpStatus.OK);
    }

    @DeleteMapping("/deleteClothes/{code}")
    public ResponseEntity<Void> deleteClothe(@PathVariable int code) {
        service.deleteClothe(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/clothesSize/{size}")
    public ResponseEntity<List<Ropa>> getRopaBySize(@PathVariable String size) {
        return new ResponseEntity<>(service.findBySize(size), HttpStatus.OK);
    }

    @GetMapping("/clothesName")
    public ResponseEntity<List<Ropa>> getByName(@RequestParam String name) {
        return new ResponseEntity<>(service.findByName(name), HttpStatus.FOUND);
    }
}
