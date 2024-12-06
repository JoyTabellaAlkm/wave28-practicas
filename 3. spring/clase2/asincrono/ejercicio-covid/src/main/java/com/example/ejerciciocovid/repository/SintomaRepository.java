package com.example.ejerciciocovid.repository;

import com.example.ejerciciocovid.model.Persona;
import com.example.ejerciciocovid.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepository {
    Sintoma sintoma1 = new Sintoma(1,"Tos",1);
    Sintoma sintoma2 = new Sintoma(2,"Fiebre",2);
    Sintoma sintoma3 = new Sintoma(3,"Dificultad para respirar",3);

    List<Sintoma> sintomas1 = new ArrayList<>(List.of(sintoma1,sintoma3));
    List<Sintoma> sintomas2 = new ArrayList<>(List.of(sintoma2,sintoma3));

    Persona persona1 = new Persona(1,"Mariano","Martinez",45,sintomas1);
    Persona persona2 = new Persona(2,"Marcelo","Tinelli",80,sintomas2);
    Persona persona3 = new Persona(3,"Luciana","Lopez",59,null);


    public List<Sintoma> sintomasData(){
        return new ArrayList<>(List.of(sintoma1,sintoma2,sintoma3));
    }

    public List<Persona> personaData(){
        return new ArrayList<>(List.of(persona1,persona2,persona3));
    }

}
