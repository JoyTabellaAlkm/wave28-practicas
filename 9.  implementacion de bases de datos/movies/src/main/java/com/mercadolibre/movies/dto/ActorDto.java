package com.mercadolibre.movies.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {
    private String firstName;
    private String lastName;
    private BigDecimal rating;
    private Integer favoriteMovieId;

}
