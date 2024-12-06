package com.example.health.dto.response.symptom;

import com.example.health.dto.SymptomDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class GetSymptomsResponse {
    List<SymptomDTO> symptoms;
}
