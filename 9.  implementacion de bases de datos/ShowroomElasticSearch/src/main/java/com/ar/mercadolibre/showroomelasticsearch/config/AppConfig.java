package com.ar.mercadolibre.showroom.config;

import com.ar.mercadolibre.showroom.dto.ClotheDTO;
import com.ar.mercadolibre.showroom.dto.SaleDTO;
import com.ar.mercadolibre.showroom.entity.Clothe;
import com.ar.mercadolibre.showroom.entity.Sale;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Sale, SaleDTO>() {
            @Override
            protected void configure() {
                // Mapea localizadamente el LocalDate directamente sin conversión adicional
                map().setFecha(source.getFecha());
            }
        });

        return modelMapper;
    }
}
