package com.example.EstructurasDinamicas.Participantes;

public class Participante {
    private int nroParticipante;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String nroEmergencia;
    private String grupoSanguineo;

    public Participante(int nroParticipante, String dni, String nombre, String apellido, int edad, String celular, String nroEmergencia, String grupoSanguineo) {
        this.nroParticipante = nroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
}
