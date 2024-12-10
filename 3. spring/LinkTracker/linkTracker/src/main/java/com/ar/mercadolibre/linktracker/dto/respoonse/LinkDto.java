package com.ar.mercadolibre.linktracker.dto.respoonse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkDto {
    @JsonProperty("link_id")
    private String linkId;
    private String url;
    @JsonProperty("masked_url")
    private String  maskedUrl;
    private String counter;
    private String password;
}
