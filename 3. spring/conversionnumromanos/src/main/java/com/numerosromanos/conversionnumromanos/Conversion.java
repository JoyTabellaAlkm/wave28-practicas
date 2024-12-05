package com.numerosromanos.conversionnumromanos;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.*;
@RestController
//@RequestMapping("/conversion")
public class Conversion {

    Map<Integer, String> numerosRomanos = new HashMap<>();

    public Conversion(){
        numerosRomanos.put(1, "I");
        numerosRomanos.put(5, "V");
        numerosRomanos.put(10, "X");
        numerosRomanos.put(50, "L");
        numerosRomanos.put(100, "C");
        numerosRomanos.put(500, "D");
        numerosRomanos.put(1000, "M");
    }


     // localhost:8080//conversion/{number}
    @GetMapping("/conversion/{numero}")
    public String conversionANumeroRomano(@PathVariable int numero) {
        if (numerosRomanos.containsKey(numero)) {
            return numerosRomanos.get(numero);
        }
        else {
            return combinarNumerosRomanosBases(numero);
        }
    }

    private String combinarNumerosRomanosBases(int numero) {
        String resultado = "";
        int resultadoNum = 0;
        for(int i = 1000; i >=  0; i-=5){
            if(numero > i) {
                if (numerosRomanos.get(i) != null) {
                    resultadoNum += i;
                    resultado += numerosRomanos.get(i) + "";
                }
            }
        }
        int resto = numero - resultadoNum;
        while(resto != 0){
             resultado += "I";
             resto--;
        }
        return resultado;
    }


}
