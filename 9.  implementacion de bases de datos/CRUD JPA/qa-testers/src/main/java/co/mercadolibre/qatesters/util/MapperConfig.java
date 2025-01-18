package co.mercadolibre.qatesters.util;

import lombok.Getter;
import org.modelmapper.ModelMapper;

public class MapperConfig {
    @Getter
    private static final ModelMapper modelMapper = new ModelMapper();

}
