package com.example.Ejercicios_IntroduccionASpring.NumerosRomanos.Service;

import com.example.Ejercicios_IntroduccionASpring.NumerosRomanos.Model.NroDecimal;
import com.example.Ejercicios_IntroduccionASpring.NumerosRomanos.Model.NroRomano;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NroService {

    public ResponseEntity<String> convertirDecimalANroRomano(NroDecimal nro){

        int i,miles, centenas, decenas, unidades;
        String nroRomano = "";
        try {
            if (nro.getValor()>0) {
                int nroDecimal = (int) Math.round(nro.getValor());

                miles = nroDecimal / 1000;
                centenas = nroDecimal / 100 % 10;
                decenas = nroDecimal / 10 % 10;
                unidades = nroDecimal % 10;

                for (i = 1; i <= miles; i++) {
                    nroRomano = nroRomano + "M";
                }
                if (centenas == 9) {
                    nroRomano = nroRomano + "CM";
                } else if (centenas >= 5) {
                    nroRomano = nroRomano + "D";
                    for (i = 6; i <= centenas; i++) {
                        nroRomano = nroRomano + "C";
                    }
                } else if (centenas == 4) {
                    nroRomano = nroRomano + "CD";
                } else {
                    for (i = 1; i <= centenas; i++) {
                        nroRomano = nroRomano + "C";
                    }
                }

                if (decenas == 9) {
                    nroRomano = nroRomano + "XC";
                } else if (decenas >= 5) {
                    nroRomano = nroRomano + "L";
                    for (i = 6; i <= decenas; i++) {
                        nroRomano = nroRomano + "X";
                    }
                } else if (decenas == 4) {
                    nroRomano = nroRomano + "XL";
                } else {
                    for (i = 1; i <= decenas; i++) {
                        nroRomano = nroRomano + "X";
                    }
                }
                if (unidades == 9) {
                    nroRomano = nroRomano + "IX";
                } else if (unidades >= 5) {
                    nroRomano = nroRomano + "V";
                    for (i = 6; i <= unidades; i++) {
                        nroRomano = nroRomano + "I";
                    }
                } else if (unidades == 4) {
                    nroRomano = nroRomano + "IV";
                } else {
                    for (i = 1; i <= unidades; i++) {
                        nroRomano = nroRomano + "I";
                    }
                }
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: El numero debe ser positivo");

            }
        }catch (NumberFormatException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Valor no válido");
        }
        NroRomano nroRomano1 = new NroRomano(nroRomano);

        return ResponseEntity.ok("Número Romano: "+nroRomano1.getValor());


    }
}
