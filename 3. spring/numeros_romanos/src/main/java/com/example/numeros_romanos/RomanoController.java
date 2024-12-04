package com.example.numeros_romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class RomanoController {
    @GetMapping
    String numToRom(@RequestParam int num){
        String numeroRomano = "";
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("M", 1000);
        romanMap.put("D", 500);
        romanMap.put("C", 100);
        romanMap.put("L", 50);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);
        for (Map.Entry<String, Integer> entry : romanMap.entrySet()) {
//            if (num >= entry.getValue()){
//                numeroRomano = numeroRomano + entry.getKey();
//                num = num - entry.getValue();
//            }else{break;}
            while(num >= entry.getValue()){
                numeroRomano = numeroRomano + entry.getKey();
                num = num - entry.getValue();
            }
        }

            return numeroRomano;
    }
}
