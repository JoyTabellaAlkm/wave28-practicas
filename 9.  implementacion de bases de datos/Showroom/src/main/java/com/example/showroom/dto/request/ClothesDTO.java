package com.example.showroom.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.processing.Pattern;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothesDTO {
    String nombre;
    @JsonProperty("fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate fecha;
    String talle;
}
