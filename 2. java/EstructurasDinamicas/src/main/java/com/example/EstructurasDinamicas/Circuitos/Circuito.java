package com.example.EstructurasDinamicas.Circuitos;

import com.example.EstructurasDinamicas.Inscripciones.Inscripcion;
import com.example.EstructurasDinamicas.Participantes.Participante;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Circuito {
    private int id;
    private String nombre;
    private String descripcion;

    private Set<Inscripcion> inscripciones;


    public Circuito(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inscripciones = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void agregarInscripcion(Inscripcion inscripcion){
        this.inscripciones.add(inscripcion);
        System.out.println("Se añadió la inscripción del participante "+ inscripcion.getParticipante().getNombre() +
                " al circuito: " + this.nombre);
    }
    public void eliminarInscripcion(Inscripcion inscripcion){
        this.inscripciones.remove(inscripcion);
        System.out.println("Se eliminó la inscripción del participante "+ inscripcion.getParticipante().getNombre() +
                " al circuito: " + this.nombre);
    }

    public double obtenerMontoRecaudadoPorCircuito (){
        double montoTotal = 0;
        for (Inscripcion ins: this.inscripciones) {
            montoTotal += ins.getMonto();
        }
        return montoTotal;
    }

    public void mostrarInscripciones(){
        for (Inscripcion i : this.inscripciones){
            System.out.println("Nombre: "+ i.getParticipante().getNombre());
            System.out.println("Edad: " + i.getParticipante().getEdad());
            System.out.println("Monto: " + i.getMonto());
        }
    }
    
}
