package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter @Setter
public class SubjectDTO {
    @Pattern(regexp = "^[A-Z].*")
    String name;
    Double score;
}
