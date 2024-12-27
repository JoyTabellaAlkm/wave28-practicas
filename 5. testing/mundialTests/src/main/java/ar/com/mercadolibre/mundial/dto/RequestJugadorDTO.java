package ar.com.mercadolibre.mundial.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestJugadorDTO {
    @NotBlank(message = "El nombre del jugador no puede estar vacío.")
    private String nombre;

    @NotBlank(message = "El pais del jugador no puede estar vacío.")
    private String pais;

    @Min(value = 0, message = "El jugador no puede tener menos de 0 goles.")
    private int goles;
}
