package org.bootcampmeli.ejerciciodeportistas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class PersonaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String edad;
    private String deporte;
}
