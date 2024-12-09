package com.bootcamp.links.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    private Integer linkId;

    private String baseUrl;

    private String shortURL;

    private int contador;

}
