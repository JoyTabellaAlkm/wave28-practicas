package com.bootcamp.social_meli.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotNull(message = "El id del usuario no puede ser nulo")
    @Min(value = 1, message = "El id del usuario debe ser mayor o igual a 1")
    private Long id;
    @NotNull
    @Length(min = 2, message = "first_name debe contener almenos 2 caracteres")
    private String first_name;
    @NotNull
    @Length(min = 2, message = "last_name debe contener almenos 2 caracteres")
    private String last_name;
    @NotNull
    @Length(min = 2, message = "username debe contener almenos 2 caracteres")
    private String username;
}
