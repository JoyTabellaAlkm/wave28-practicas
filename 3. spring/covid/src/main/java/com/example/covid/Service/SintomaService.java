package com.example.covid.Service;

import com.example.covid.Model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SintomaService implements IService<Sintoma>{
    Map<Integer,Sintoma> mapSintoma = new HashMap<>();


    @Override
    public Sintoma obtener(int id) {
        for (Map.Entry<Integer, Sintoma> entry : mapSintoma.entrySet()) {
            Sintoma sintoma = entry.getValue();
            if (sintoma.getCodigo()== id) {
                return sintoma;
            }
        }
        return null;    }

    public Sintoma obtenerXNombre(String nombre) {
        for (Map.Entry<Integer, Sintoma> entry : mapSintoma.entrySet()) {
            Sintoma sintoma = entry.getValue();
            if (sintoma.getNombre().equalsIgnoreCase(nombre)) {
                return sintoma;
            }
        }
        return null;
    }


    @Override
    public void crear(Sintoma sintoma) {
        mapSintoma.put(sintoma.getCodigo(),sintoma);

    }

    @Override
    public void eliminar(int id) {
        mapSintoma.remove(id);

    }

    @Override
    public void editar(int id, Sintoma sintoma) {

    }

    @Override
    public List<Sintoma> obtenerTodos() {
        return new ArrayList<>(mapSintoma.values());
    }
}
