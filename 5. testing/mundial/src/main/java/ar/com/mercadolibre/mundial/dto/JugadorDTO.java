package ar.com.mercadolibre.mundial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO {
    private int id;
    private String nombre;
    private String pais;
    private int goles;
}
