package com.mercadolibre.lasperlas.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJoyaDtoResponse {

    @JsonAlias("nro_identificatorio")
    private long nroIdentificatorio;

}
