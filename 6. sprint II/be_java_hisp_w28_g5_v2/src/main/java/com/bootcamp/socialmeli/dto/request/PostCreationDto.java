package com.bootcamp.socialmeli.dto.request;

import com.bootcamp.socialmeli.util.validation.message.PostValidationMessage;
import com.bootcamp.socialmeli.util.validation.message.ValidationMessage;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreationDto {
    @Min(value=1,message = PostValidationMessage.MIN_USER_ID)
    @NotNull(message = PostValidationMessage.USER_ID_NOT_NULL)
    private Long user_id;

    @NotBlank(message = PostValidationMessage.DATE_NOT_NULL)
    private String date;

    @Valid
    private ProductCreationDto product;

    @NotNull(message = PostValidationMessage.CATEGORY_NOT_NULL)
    private Integer category;

    @NotNull(message = PostValidationMessage.PRICE_NOT_NULL)
    @Max(value = 10000000,message = PostValidationMessage.MAX_PRICE)
    @Min(value = 0, message = PostValidationMessage.MIN_PRICE)
    private Double price;
}
