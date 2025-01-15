package com.mercadolibre.llavecompuesta.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compras")
@IdClass(Compra.CompraId.class)
public class Compra {

    @Id
    @Column(name = "cliente_id")
    private Long clienteId;

    @Id
    @Column(updatable = false)
    private LocalDateTime fecha;

    @Column
    private Long cantidad;

    @Column
    private Double precio;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompraId implements Serializable {

        private Long clienteId;
        private LocalDateTime fecha;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            CompraId compraId = (CompraId) o;
            return clienteId.equals(compraId.clienteId) && fecha.equals(compraId.fecha);
        }

        @Override
        public int hashCode() {
            return Objects.hash(clienteId, fecha);
        }

    }

}
