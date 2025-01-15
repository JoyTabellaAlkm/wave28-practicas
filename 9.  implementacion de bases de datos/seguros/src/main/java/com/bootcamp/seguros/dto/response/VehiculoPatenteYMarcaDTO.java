package com.bootcamp.seguros.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoPatenteYMarcaDTO {
    String patente;
    String marca;
}
