package com.mercadolibre.clavecompuesta.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.Objects;

@Setter
@Getter
public class CompraKey implements Serializable {
    private Long clienteId;
    private LocalDate fecha;

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
