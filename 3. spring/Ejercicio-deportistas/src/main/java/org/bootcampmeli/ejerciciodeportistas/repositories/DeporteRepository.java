package org.bootcampmeli.ejerciciodeportistas.repositories;

import lombok.Getter;
import lombok.Setter;
import org.bootcampmeli.ejerciciodeportistas.dto.DeporteDTO;
import org.bootcampmeli.ejerciciodeportistas.dto.DeportistaDTO;
import org.bootcampmeli.ejerciciodeportistas.model.Deporte;
import org.bootcampmeli.ejerciciodeportistas.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
public class DeporteRepository {



    private static final List<Deporte> deportes = new ArrayList<>();


    private static final List<Persona> personas = new ArrayList<>();

    static {

        Deporte futbol = new Deporte("Futbol", "Alto");
        Deporte tenis = new Deporte("Tenis", "Medio");


        deportes.add(futbol);
        deportes.add(tenis);


        personas.add(new Persona("Lisandro", "Alo", 30, futbol));
        personas.add(new Persona("Lucas", "Caraballo", 25, tenis));
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }


    public String findByName(String name) {
        return this.getPersonas().stream().filter((p) -> p.getNombre().equals(name)).findFirst().get().getDeporte().getNivel();

    }

    public List<DeporteDTO> findSports(){

        return this.getDeportes().stream().map(d -> new DeporteDTO(d.getNombre(), d.getNivel())).toList();
    }

    public List<DeportistaDTO> findSportPersons() {
        return this.getPersonas().stream().map((p) -> new DeportistaDTO(p.getNombre(),p.getApellido(),p.getDeporte().getNombre())).toList();
    }


}