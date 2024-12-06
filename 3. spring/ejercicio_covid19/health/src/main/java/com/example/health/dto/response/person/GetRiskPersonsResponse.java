package com.example.health.dto.response.person;

import com.example.health.dto.RiskPersonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class GetRiskPersonsResponse {
    private List<RiskPersonDTO> riskyPersons;
}
