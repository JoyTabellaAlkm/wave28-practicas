package ejercicio.relaciones.model.ClavesCompuestas;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "people")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(value = PersonKey.class)
public class Person {
    @Id
    private Integer dni;
    @Id
    private Integer numTramite;


}
