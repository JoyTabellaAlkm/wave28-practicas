package com.mercadolibre.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer id;
    private String link;
    private String password;
    private Integer counter;

    public void incrementCounter() {
        counter++;
    }
}
