package com.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestRedireccionDto {
    private Long linkId;
    private String password;
}
