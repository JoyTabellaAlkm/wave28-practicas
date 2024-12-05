package ejercicios.mascota.dto;

import ejercicios.mascota.dto.requests.PersonaDto;
import lombok.Data;

@Data
public class ClienteDto {

    private PersonaDto persona;
    private MascotaDto mascota;
}
