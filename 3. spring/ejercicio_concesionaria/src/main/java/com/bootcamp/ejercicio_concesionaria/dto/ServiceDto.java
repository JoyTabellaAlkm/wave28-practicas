package com.bootcamp.ejercicio_concesionaria.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto implements Serializable {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
