package ar.com.mercadolibre.mundial.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {
    private int id;
    private String nombre;
    private String pais;
    private int goles;
}
