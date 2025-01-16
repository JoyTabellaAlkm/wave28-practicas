package com.example.showroom.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClothesDTOResponse {
    Long id;
    String nombre;
    @JsonProperty("fecha")
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate fecha;
    String talle;
}
