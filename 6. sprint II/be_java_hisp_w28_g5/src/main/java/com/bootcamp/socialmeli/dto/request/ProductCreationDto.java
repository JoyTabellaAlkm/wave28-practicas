package com.bootcamp.socialmeli.dto.request;

import com.bootcamp.socialmeli.util.validation.ValidationRegex;
import com.bootcamp.socialmeli.util.validation.message.ProductValidationMessage;
import com.bootcamp.socialmeli.util.validation.message.ValidationMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreationDto {
    @JsonProperty("product_id")
    @Min(value=1,message= ProductValidationMessage.MIN_USER_ID)
    @NotNull(message=ValidationMessage.USER_ID_NOT_NULL)
    private Long id;

    @JsonProperty("product_name")
    @NotBlank(message = ProductValidationMessage.NAME_NOT_NULL)
    @Size(max = 40,message = ProductValidationMessage.NAME_MAX_LENGTH)
    @Pattern(regexp = ValidationRegex.ALPHANUMERIC_ONLY, message = ProductValidationMessage.NAME_PATTERN)
    private String name;

    @NotBlank(message = ProductValidationMessage.TYPE_NOT_NULL)
    @Size(max = 15,message = ProductValidationMessage.TYPE_MAX_LENGTH)
    @Pattern(regexp = ValidationRegex.ALPHANUMERIC_ONLY, message = ProductValidationMessage.TYPE_PATTERN)
    private String type;

    @NotBlank(message = ProductValidationMessage.BRAND_NOT_NULL)
    @Size(max = 25,message = ProductValidationMessage.BRAND_MAX_LENGTH)
    @Pattern(regexp = ValidationRegex.ALPHANUMERIC_ONLY, message = ProductValidationMessage.BRAND_PATTERN)
    private String brand;

    @NotBlank(message = ProductValidationMessage.COLOR_NOT_NULL)
    @Size(max = 15,message = ProductValidationMessage.COLOR_MAX_LENGTH)
    @Pattern(regexp = ValidationRegex.ALPHANUMERIC_ONLY, message = ProductValidationMessage.COLOR_PATTERN)
    private String color;

    @Size(max = 80,message = ProductValidationMessage.NOTES_MAX_LENGTH)
    @Pattern(regexp = ValidationRegex.ALPHANUMERIC_ONLY, message = ProductValidationMessage.NOTES_PATTERN)
    private String notes;
}
