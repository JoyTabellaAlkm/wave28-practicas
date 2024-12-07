package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dto.SintomaDTO;

import java.util.List;

public interface ISintoma {
    SintomaDTO agregarSintoma(SintomaDTO sintoma);

    String obtenersintonas(String sintoma);
}
