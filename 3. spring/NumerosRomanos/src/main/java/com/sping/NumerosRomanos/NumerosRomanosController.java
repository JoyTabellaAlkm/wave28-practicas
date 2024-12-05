package com.sping.NumerosRomanos;

import com.sun.source.tree.Tree;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController
@RequestMapping("/api/roman")
public class NumerosRomanosController {


    @GetMapping("/toRoman/{number}")
    public ResponseEntity<String> toRoman(@PathVariable int number) {
        String roman = "";
        TreeMap<Integer, String> numerosRomanos = new TreeMap<>();
        numerosRomanos.put(1000, "M");
        numerosRomanos.put(900, "CM");
        numerosRomanos.put(500, "D");
        numerosRomanos.put(400, "CD");
        numerosRomanos.put(100, "C");
        numerosRomanos.put(90, "XC");
        numerosRomanos.put(50, "L");
        numerosRomanos.put(40, "XL");
        numerosRomanos.put(10, "X");
        numerosRomanos.put(9, "IV");
        numerosRomanos.put(5, "V");
        numerosRomanos.put(4, "IV");
        numerosRomanos.put(1, "I");
        if (number <= 0 || number > 3999) {
            return ResponseEntity.badRequest().body("Numero invalido");
        }
        roman = convertToRoman(number,numerosRomanos);
        return ResponseEntity.ok(roman);
    }

    @PostMapping

    public static String convertToRoman(int number, TreeMap<Integer, String> map) {
        String roman = "";
        Integer l = map.floorKey(number);
        if(number == l){
            roman = map.get(number);
        }else {
            roman = map.get(l)+convertToRoman(number-l,map);
        }
        return roman;
    }



}
