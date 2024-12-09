package com.concesionariaapi.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    public String message;
    public Integer id;
}
