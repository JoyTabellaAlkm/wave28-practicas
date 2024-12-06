package com.example.covid.Service;

import com.example.covid.Model.Persona;
import com.example.covid.Model.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class PersonaService implements IService<Persona>{
    Map<Integer,Persona> mapPersona = new HashMap<>();


    @Override
    public Persona obtener(int id) {
        for (Map.Entry<Integer, Persona> entry : mapPersona.entrySet()) {
            Persona persona = entry.getValue();
            if (persona.getId()== id) {
                return persona;
            }
        }
        return null;    }



    @Override
    public void crear(Persona persona) {
        mapPersona.put(persona.getId(),persona);

    }

    @Override
    public void eliminar(int id) {
        mapPersona.remove(id);
    }

    @Override
    public void editar(int id, Persona persona) {

    }

    @Override
    public List<Persona> obtenerTodos() {
        return new ArrayList<>(mapPersona.values());
    }

    public List<Persona> obtenerEdad60() {
        List<Persona> personas60 = new ArrayList<>(mapPersona.values());
        for (Map.Entry<Integer, Persona> entry : mapPersona.entrySet()) {
            Persona persona = entry.getValue();
            if (persona.getEdad()>60) {
                personas60.add(persona);
            }
        }
        return personas60;
    }
}
