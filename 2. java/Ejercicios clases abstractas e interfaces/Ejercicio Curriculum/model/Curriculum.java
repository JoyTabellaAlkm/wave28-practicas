package org.example.model;

import org.example.IImprimible;

import java.util.List;

public class Curriculum implements IImprimible {

    private Persona persona;
    private List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public String imprimir() {
        return toString();
    }
}