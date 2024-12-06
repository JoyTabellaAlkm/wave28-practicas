package com.mercadolibre.covid19.repository.impl;

import com.mercadolibre.covid19.model.Persona;
import com.mercadolibre.covid19.model.Sintoma;
import com.mercadolibre.covid19.repository.CRUD;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements CRUD<Persona> {
    //lista porque no tenemos bd
    List<Persona> listaPersonas = new ArrayList<>();
    @Override
    public List<Persona> buscar() {
        cargarDatos();
        return listaPersonas;
    }

    @Override
    public Persona buscarPorNombre(String nombre) {
        return null;
    }

    private void cargarDatos(){
        Sintoma sintoma1 = new Sintoma("0001","Tos","Bajo");
        Sintoma sintoma2 = new Sintoma("0002","Dolor de cabeza","Medio");
        Sintoma sintoma3 = new Sintoma("0003","Fiebere","Alto");
        Sintoma sintoma4 = new Sintoma("0004","Alergia","Medio");

        Persona persona1 = new Persona("0001","Juan","Abarca",22,List.of(sintoma1,sintoma3));
        Persona persona2 = new Persona("0002","Norberto","Abarca",62,List.of(sintoma3,sintoma4));
        Persona persona3 = new Persona("0003","Aragon","Pixar",60,List.of(sintoma1,sintoma2));
        Persona persona4 = new Persona("0004","Alfonso","Loyola",59,List.of(sintoma3));
        Persona persona5 = new Persona("0005","Bom","Bon",65,List.of(sintoma4));
        Persona persona6 = new Persona("0006","Jorge","Bon",62,List.of());
        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);
        listaPersonas.add(persona6);

    }

}
