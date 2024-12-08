package com.mercadolibre.deportistas.dto;

import com.mercadolibre.deportistas.model.Deporte;
import com.mercadolibre.deportistas.model.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDeporteDTO {

    private String nombreDeportista;
    private String apellidoDeportista;
    private String nombreDeporte;

    public PersonaDeporteDTO(Persona persona) {
        this.nombreDeporte = persona.getDeporte().getNombre();
        this.nombreDeportista = persona.getNombre();
        this.apellidoDeportista = persona.getApellido();
    }

    public static PersonaDeporteDTO fromEntity(Persona persona) {
        return new PersonaDeporteDTO(persona);
    }
}
