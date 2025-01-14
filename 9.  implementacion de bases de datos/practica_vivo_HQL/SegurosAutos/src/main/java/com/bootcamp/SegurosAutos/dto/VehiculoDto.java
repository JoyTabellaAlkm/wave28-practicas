package com.bootcamp.SegurosAutos.dto;

import com.bootcamp.SegurosAutos.entity.Siniestro;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoDto {
    String patente;
    String marca;
    String modelo;
    LocalDate fabricacion;
    @JsonProperty("cantidad_ruedas")
    Integer cantidadRuedas;
}
