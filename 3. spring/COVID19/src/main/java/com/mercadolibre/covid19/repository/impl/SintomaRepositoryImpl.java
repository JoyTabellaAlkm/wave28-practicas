package com.mercadolibre.covid19.repository.impl;

import com.mercadolibre.covid19.dto.SintomaDTO;
import com.mercadolibre.covid19.model.Sintoma;
import com.mercadolibre.covid19.repository.CRUD;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SintomaRepositoryImpl implements CRUD<Sintoma> {
    //Lista ya que no manejamos base de datos
    List<Sintoma> listaSintomas = new ArrayList<>();

    @Override
    public List<Sintoma> buscar() {
        //carga hipotica inicial
        cargarDatos();

        return listaSintomas;
    }

    @Override
    public Sintoma buscarPorNombre(String nombreSintoma) {
        //carga hipotetica incial
        //cargarDatos();
        Sintoma sintomaBuscado = listaSintomas.stream()
                .filter(sintoma -> sintoma.getNombre()
                        .toUpperCase().contains(nombreSintoma.toUpperCase()))
                .findFirst().orElse(null);

        return sintomaBuscado;
    }

    private void cargarDatos(){
        Sintoma sintoma1 = new Sintoma("0001","Tos","Bajo");
        Sintoma sintoma2 = new Sintoma("0002","Dolor de cabeza","Medio");
        Sintoma sintoma3 = new Sintoma("0003","Fiebere","Alto");
        Sintoma sintoma4 = new Sintoma("0004","Alergia","Medio");
        listaSintomas.add(sintoma1);
        listaSintomas.add(sintoma2);
        listaSintomas.add(sintoma3);
        listaSintomas.add(sintoma4);
    }
}
