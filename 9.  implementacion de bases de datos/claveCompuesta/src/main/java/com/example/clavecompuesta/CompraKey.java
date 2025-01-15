package com.example.clavecompuesta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraKey implements Serializable {
    Long clienteId;
    LocalDate fecha;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompraKey compraKey = (CompraKey) o;
        return Objects.equals(clienteId, compraKey.clienteId) && Objects.equals(fecha, compraKey.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, fecha);
    }
}
