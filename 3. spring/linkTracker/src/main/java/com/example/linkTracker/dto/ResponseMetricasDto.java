package com.example.linkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMetricasDto {
    private Long id;
    private String link;
    private int numberRedirects;
}
