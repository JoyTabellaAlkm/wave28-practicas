package com.bootcamp.social_meli.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDTO {
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
