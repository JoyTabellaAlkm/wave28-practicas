package com.mercadolibre.clavecompuesta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    private Long clienteId;
    @Id
    private LocalDate fecha;
    private String detalles;
    private Double total;
}
