package com.example.deportista.dto.response;

import com.example.deportista.dto.request.DeporteDTO;
import lombok.Data;

import java.util.List;

@Data
public class DeportesResponseDto {
    private List<DeporteDTO> deportesDto;
}
