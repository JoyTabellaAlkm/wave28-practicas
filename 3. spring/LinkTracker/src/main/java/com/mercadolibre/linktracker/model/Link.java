package com.mercadolibre.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private Long id;
    private String originalLink;
    private String password;
    private int counter;
    private Boolean isActive;
}
