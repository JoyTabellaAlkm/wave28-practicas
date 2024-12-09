package com.mercadolibre.linktracker.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkInvalidatedDTO {
    private Long linkId;
    private String originalLink;
    private boolean isActive;
}
