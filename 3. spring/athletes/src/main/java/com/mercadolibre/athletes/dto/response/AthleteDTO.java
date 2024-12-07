package com.mercadolibre.athletes.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteDTO {
    private String firstname;
    private String lastname;
    private List<String> sports;
}
