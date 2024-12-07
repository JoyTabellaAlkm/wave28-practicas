package com.bootcamp.concesionariaautos.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private String date;
    @JsonAlias({"km"})
    private String kilometers;
    private String description;
}
