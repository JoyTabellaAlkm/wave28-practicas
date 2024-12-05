package com.melibootcamp.covid19.repositories;

import com.melibootcamp.covid19.entities.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SintomaRepository {

    private List<Sintoma> sintomaList;

    public SintomaRepository(){
        sintomaList = new ArrayList<>();
        sintomaList.add(new Sintoma(1, "Fiebre", 2  ));
        sintomaList.add(new Sintoma(2, "Tos seca", 2  ));
        sintomaList.add(new Sintoma(3, "Cansancio", 2  ));
        sintomaList.add(new Sintoma(4, "Pérdida del gusto o del olfato", 1  ));
        sintomaList.add(new Sintoma(5, "Dolor de garganta", 1  ));
        sintomaList.add(new Sintoma(6, "Dolor de cabeza", 1  ));
        sintomaList.add(new Sintoma(7, "Dificultad para respirar", 3  ));
        sintomaList.add(new Sintoma(8, "Dolor en el pecho", 3  ));
        sintomaList.add(new Sintoma(9, "Escalofríos", 2  ));
        sintomaList.add(new Sintoma(10, "Congestión nasal", 1  ));
        sintomaList.add(new Sintoma(11, "Dolor muscular o articular", 2  ));
        sintomaList.add(new Sintoma(12, "Náuseas o vómitos", 2  ));
        sintomaList.add(new Sintoma(13, "Diarrea", 2  ));
    }

    public List<Sintoma> devolverSintomas(){
        return sintomaList;
    }

    public Sintoma devolverSintomaPorCodigo(int codigo){
        Optional<Sintoma> toReturn = sintomaList.stream().filter(x -> x.getCodigo() == codigo).findFirst();
        if(toReturn.isPresent()){
            return toReturn.get();
        }
        return null;
    }

    public Sintoma devolverSintomaPorNombre(String nombre){
        Optional<Sintoma> toReturn = sintomaList.stream().filter(x -> x.getNombre().equals(nombre)).findFirst();
        if(toReturn.isPresent()){
            return toReturn.get();
        }
        return null;
    }



}
