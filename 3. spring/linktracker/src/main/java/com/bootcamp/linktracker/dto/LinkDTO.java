package com.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDTO {
    private Integer id;
    private String password;
    private Integer cantRedirecciones = 0;
    private String link;
}
