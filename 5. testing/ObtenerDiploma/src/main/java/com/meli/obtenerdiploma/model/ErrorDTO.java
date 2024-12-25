package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ErrorDTO {
    private List<String> errors;

    public ErrorDTO(List<String> errors) {
        this.errors = errors;
    }

}
