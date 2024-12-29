package com.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
public record StudentDTO(

    Long id,

    String studentName,

    Set< SubjectDTO> subjects
){
}
