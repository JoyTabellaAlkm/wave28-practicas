package com.example.jewerly_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCreateDto {
    private Long nro_identificador;
    private String mensaje;
}
