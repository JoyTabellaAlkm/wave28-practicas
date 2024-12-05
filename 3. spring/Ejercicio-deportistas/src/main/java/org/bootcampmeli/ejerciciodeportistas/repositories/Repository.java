package org.bootcampmeli.ejerciciodeportistas.repositories;

import org.bootcampmeli.ejerciciodeportistas.model.Deporte;
import org.bootcampmeli.ejerciciodeportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;



@org.springframework.stereotype.Repository
public class Repository {



    private static final List<Deporte> deportes = new ArrayList<>();
    private static final List<Persona> personas = new ArrayList<>();

    static {
        // Datos de ejemplo
        deportes.add(new Deporte("Futbol", "Alto"));
        deportes.add(new Deporte("Tenis", "Medio"));

        personas.add(new Persona("Lisandro", "Alo", 30, deportes.get(0)));
        personas.add(new Persona("Lucas", "Caraballo", 25, deportes.get(1)));
    }



    public List<Deporte> findAllDeportes() {
        return deportes;
    }

    public Deporte findByName(String name) {
        return this.findAllDeportes().stream().filter((d) -> d.getNombre().equals(name)).findFirst().get();


    }


    public List<Persona> findAllPersonas() {
        return new ArrayList<>(personas);
    }

    public void add(Deporte deporte) {
        deportes.add(deporte);
    }



}