package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "Subject name must not be blank or null")
    @Size(min = 3, max = 20, message = "Subject name must contain between 3 and 20 characters")
    String name;

    @NotNull(message = "Score must not be blank or null")
    @Min(value = 0, message = "Score must be greater than or equal to 0")
    @Max(value = 10, message = "Score must be less than or equal to 10")
    Double score;
}
