package com.bootcamp.ejercicioautos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PostServiceDto {
    private String date;
    private String kilometers;
    private String descriptions;
}
