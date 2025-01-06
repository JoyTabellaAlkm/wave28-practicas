package com.bootcamp.social_meli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParsingErrorResponseDTO {
    private int status;
    private String message;
    private String caused_by;
}
