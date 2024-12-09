package com.mercadolibre.linkredirect.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private Long id;
    private String link;
    private Integer viewCount;
    private String password;
    private Boolean valid;
}
