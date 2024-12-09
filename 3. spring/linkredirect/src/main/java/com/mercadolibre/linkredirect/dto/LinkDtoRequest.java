package com.mercadolibre.linkredirect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDtoRequest {
    private Long id;
    private String link;
    private Integer viewCount;
    private String password;
    private Boolean valid;
}
