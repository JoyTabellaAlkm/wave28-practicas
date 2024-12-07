package com.meli.deportista.dto;

public class DeportePersonaDto {
    private DeporteDto deporte;


    private PersonaDto persona;

    public DeportePersonaDto() {
    }

    public DeportePersonaDto(DeporteDto deporte, PersonaDto persona) {
        this.deporte = deporte;
        this.persona = persona;
    }

    public DeporteDto getDeporte() {
        return deporte;
    }

    public void setDeporte(DeporteDto deporte) {
        this.deporte = deporte;
    }

    public PersonaDto getPersona() {
        return persona;
    }

    public void setPersona(PersonaDto persona) {
        this.persona = persona;
    }
}