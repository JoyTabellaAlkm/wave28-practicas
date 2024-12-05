package ejercicios.mascota.dto.requests;

import ejercicios.mascota.dto.MascotaDto;
import lombok.Data;

@Data
public class PersonaDto {

    private String nombre;
    private String apellido;
    private MascotaDto mascota;
}
