package co.mercadolibre.movieshql.config;

import lombok.Getter;
import org.modelmapper.ModelMapper;

public class ModelMapperConfig {
    @Getter
    private static final ModelMapper modelMapper = new ModelMapper();
}
