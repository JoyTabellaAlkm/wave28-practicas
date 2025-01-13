package com.mercadolibre.joyeria.utils.mapper;

import com.mercadolibre.joyeria.dto.JoyaDto;
import com.mercadolibre.joyeria.model.Joya;

public class JoyaMapper {
    private JoyaMapper() {}

    public static JoyaDto toJoyaDto(Joya j) {
        return new JoyaDto(
                j.getNombre(),
                j.getMaterial(),
                j.getPeso(),
                j.getParticularidad(),
                j.isPoseePiedra(),
                j.isVentaONo()
        );
    }

    public static Joya toJoya(JoyaDto joyaDto) {
        return new Joya(
                null,
                joyaDto.getNombre(),
                joyaDto.getMaterial(),
                joyaDto.getPeso(),
                joyaDto.getParticularidad(),
                joyaDto.isPoseePiedra(),
                joyaDto.isVentaONo()
        );
    }


}
