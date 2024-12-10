package com.ar.mercadolibre.linktracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkRequestDto {
    private String url;
    private Optional<String> password;

    public LinkRequestDto(String url, String password) {
        this.url = url;
        this.password = Optional.ofNullable(password);
    }
}
