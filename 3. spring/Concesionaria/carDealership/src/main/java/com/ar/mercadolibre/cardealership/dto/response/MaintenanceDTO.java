package com.ar.mercadolibre.cardealership.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"autoIncrementalId"})
@Data
public class MaintenanceDTO {

    private Long id;
    private String date;
    private String kilometers;
    private String descriptions;
}
