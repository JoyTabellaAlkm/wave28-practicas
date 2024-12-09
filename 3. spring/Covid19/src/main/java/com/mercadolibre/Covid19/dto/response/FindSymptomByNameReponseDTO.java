package com.mercadolibre.Covid19.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class FindSymptomByNameReponseDTO {
    public String nivel_de_gravedad;

    public String getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(String nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public FindSymptomByNameReponseDTO() {
    }

    public FindSymptomByNameReponseDTO(String nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
