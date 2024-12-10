package com.bootcamp.concesionaria.mapper;

import com.bootcamp.concesionaria.dto.ServiceDTO;
import com.bootcamp.concesionaria.model.Service;
import com.bootcamp.concesionaria.util.DateUtils;

public class ServiceMapper {
    private ServiceMapper() {}

    public static Service from(ServiceDTO dto) {
        return new Service(
                null,
                DateUtils.localDateFrom(dto.getDate()),
                dto.getKilometers(),
                dto.getDescriptions()
        );
    }

    public static ServiceDTO toServiceDTO(Service s) {
        return new ServiceDTO(
                DateUtils.toString(s.getDate()),
                s.getKilometers(),
                s.getDescriptions()
        );
    }
}
