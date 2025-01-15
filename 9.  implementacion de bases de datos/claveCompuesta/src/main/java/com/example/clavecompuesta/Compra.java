package com.example.clavecompuesta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    Long clienteId;
    @Id
    LocalDate fecha;
    String tipoCompra;
}
