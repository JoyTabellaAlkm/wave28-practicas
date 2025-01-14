package com.mercadolibre.movies.dto;

import com.mercadolibre.movies.model.ActorMovie;
import com.mercadolibre.movies.model.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private String title;
    private BigDecimal rating;
    private Integer awards;
    private Date releaseDate;
    private Integer length;
}
