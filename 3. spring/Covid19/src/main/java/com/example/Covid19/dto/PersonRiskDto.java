package com.example.Covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRiskDto {
    private String name;
    private String lastname;
    private List<String> symptoms;
}
