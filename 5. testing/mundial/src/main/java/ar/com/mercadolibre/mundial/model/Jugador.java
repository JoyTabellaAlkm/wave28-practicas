package ar.com.mercadolibre.mundial.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//EL @Data ya tiene el @EqualsAndHashCode
public class Jugador {
    private int id;
    private String nombre;
    private String pais;
    private int goles;
}