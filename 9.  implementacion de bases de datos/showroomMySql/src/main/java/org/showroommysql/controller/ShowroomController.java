package org.showroommysql.controller;

import org.showroommysql.entity.Ropa;
import org.showroommysql.entity.Venta;
import org.showroommysql.service.iRopaService;
import org.showroommysql.service.iVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShowroomController {
    
    @Autowired
    private iVentaService serviceV;
    
    @Autowired
    private iRopaService serviceR;

    @PostMapping("/createRopa")
    public ResponseEntity<Ropa> postRopa(@RequestBody Ropa r) {
        return new ResponseEntity<>(serviceR.create(r), HttpStatus.CREATED);
    }

    @PostMapping("/createVenta")
    public ResponseEntity<Venta> postVenta(@RequestBody Venta v) {
        return new ResponseEntity<>(serviceV.create(v), HttpStatus.CREATED);
    }

    @GetMapping("/getAllRopa")
    public ResponseEntity<List<Ropa>> getRopa() {
        return new ResponseEntity<>(serviceR.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getAllVenta")
    public ResponseEntity<List<Venta>> getVenta() {
        return new ResponseEntity<>(serviceV.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getRopa")
    public ResponseEntity<Ropa> getEspecificRopa(@RequestParam int codigo) {
        return new ResponseEntity<>(serviceR.getEspecificClothe(codigo), HttpStatus.OK);
    }

    @GetMapping("/getVenta")
    public ResponseEntity<Venta> getEspecificVenta(@RequestParam int numero) {
        return new ResponseEntity<>(serviceV.getEspecificSale(numero), HttpStatus.OK);
    }

    @PutMapping("/updateRopa/{codigo}")
    public ResponseEntity<Ropa> putRopa(@PathVariable int codigo, @RequestBody Ropa ropa) {
        return new ResponseEntity<>(serviceR.updateClothe(codigo,ropa), HttpStatus.OK);
    }

    @PutMapping("/updateVenta/{numero}")
    public ResponseEntity<Venta> putVenta(@PathVariable int numero, @RequestBody Venta venta) {
        return new ResponseEntity<>(serviceV.updateSale(numero,venta), HttpStatus.OK);
    }

    @DeleteMapping("/deleteRopa/{codigo}")
    public ResponseEntity<Void> deleteRopa(@PathVariable int codigo) {
        serviceR.deleteClothe(codigo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteVenta/{numero}")
    public ResponseEntity<Void> deleteVenta(@PathVariable int numero) {
        serviceV.deleteSale(numero);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/gerRopaTalle")
    public ResponseEntity<List<Ropa>> getRopaTalle(@RequestParam String talle) {
        return new ResponseEntity<>(serviceR.getTalle(talle), HttpStatus.OK);
    }

    @GetMapping("/getRopaNombre")
    public ResponseEntity<List<Ropa>> getRopaNombre(@RequestParam String nombre) {
        return new ResponseEntity<>(serviceR.getNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/getVentaDate")
    public ResponseEntity<List<Venta>> get(@RequestParam LocalDate date) {
        return new ResponseEntity<>(serviceV.getAllDate(date), HttpStatus.OK);
    }

    @GetMapping("/getRopaByVenta")
    public ResponseEntity<List<Ropa>> getRopaByVenta(@RequestParam int numero) {
        return new ResponseEntity<>(serviceV.getAllClotheBySale(numero), HttpStatus.OK);
    }
}
