package com.bootcamp.ejercicio_links.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDto {
    private Integer contador;
    private String password;
    private String linkUrl;
    private String shortUrl;
}
