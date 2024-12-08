package com.mercadolibre.concesionariaautos.dto;

import com.mercadolibre.concesionariaautos.model.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDTO {

    public ServiceDTO(Service service) {
        this.date = service.getDate();
        this.kilometers = service.getKilometers();
        this.descriptions = service.getDescriptions();
    }

    private LocalDate date;
    private Double kilometers;
    private String descriptions;

    public static ServiceDTO fromEntity(Service service) {
        return new ServiceDTO(service);
    }
}
