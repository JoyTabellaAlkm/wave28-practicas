package com.bootcamp.links.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {

    private Integer linkId;

    private String baseUrl;

    private String shortURL;

    private int contador;

}
