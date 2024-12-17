package com.ejercicios.covid19.DTO;

import com.ejercicios.covid19.models.Persona;
import com.ejercicios.covid19.models.Sintoma;

import java.util.List;

public class PacienteDTO {
    private Persona persona;
    private List<Sintoma> sintomas;

    public PacienteDTO(Persona persona, List<Sintoma> sintomas) {
        this.persona = persona;
        this.sintomas = sintomas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }
}
