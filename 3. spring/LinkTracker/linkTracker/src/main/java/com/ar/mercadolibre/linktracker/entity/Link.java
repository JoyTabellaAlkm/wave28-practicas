package com.ar.mercadolibre.linktracker.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {
    @JsonProperty("link_id")
    private String linkId;
    private String url;
    @JsonProperty("masked_url")
    private String  maskedUrl;
    private long counter;
    private String password;

    public Link(String linkId, String url, String maskedUrl, String password) {
        this.linkId = linkId;
        this.url = url;
        this.maskedUrl = maskedUrl;
        this.counter = 0;
        this.password = password;
    }
}
