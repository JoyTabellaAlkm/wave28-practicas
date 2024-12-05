package ejercicios.mascota.dto.responses;

import lombok.Data;

@Data
public class RespuestaDto {
    private String respuesta;

    public RespuestaDto(String personaAgregada) {
        this.respuesta= personaAgregada;
    }
}
