package co.mercadolibre.concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
