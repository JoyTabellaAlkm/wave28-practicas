package co.mercadolibre.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDTO {
    private String nombre, apellido;
    private String deporte;
}
