package com.example.EstructurasDinamicas.Inscripciones;

import com.example.EstructurasDinamicas.Circuitos.Circuito;
import com.example.EstructurasDinamicas.Participantes.Participante;

public class Inscripcion {
    private int nroInscripcion;
    private Circuito circuito;
    private Participante participante;
    private double monto;

    public Inscripcion(int nroInscripcion, Circuito circuito, Participante participante) {
        this.nroInscripcion = nroInscripcion;
        this.circuito = circuito;
        this.participante = participante;
        this.monto = calcularMonto(circuito.getId(), participante.getEdad());
        boolean condicionMenores = (participante.getEdad()<18 && circuito.getId()==3);
        if (!condicionMenores){
            circuito.agregarInscripcion(this);}
    }


    public Inscripcion() {
    }

    public Participante getParticipante() {
        return participante;
    }

    public double getMonto() {
        return monto;
    }

    public static double calcularMonto(int idCircuito, int edad){
        double monto = 0;
        switch (idCircuito){
            case 1:
                monto = edad >= 18 ? 1500 : 1300;
                break;
            case 2:
                monto = edad >= 18 ? 2300 : 2000;
                break;
            case 3:
                if(edad >= 18) monto = 2800;
                if (edad < 18) {
                    System.out.println("Los menores de 18 no se pueden inscribir en este circuito");
                }
        }
        return monto;
    }
}
