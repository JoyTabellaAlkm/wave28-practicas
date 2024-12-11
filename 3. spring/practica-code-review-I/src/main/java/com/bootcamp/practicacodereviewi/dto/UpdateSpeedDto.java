package com.bootcamp.practicacodereviewi.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class UpdateSpeedDto {
    private String maxSpeed;
}
