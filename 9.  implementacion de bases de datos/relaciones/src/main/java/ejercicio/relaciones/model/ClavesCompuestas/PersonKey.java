package ejercicio.relaciones.model.ClavesCompuestas;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonKey implements Serializable {
    private Integer dni;
    private Integer numTramite;
}
