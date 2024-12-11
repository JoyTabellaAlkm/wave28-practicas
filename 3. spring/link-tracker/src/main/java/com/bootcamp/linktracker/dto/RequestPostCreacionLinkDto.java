package com.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestPostCreacionLinkDto {
    private String link;
    private String password;
}
