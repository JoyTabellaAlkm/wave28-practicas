package com.mercadolibre.ejerciciohql.dto;

import com.mercadolibre.ejerciciohql.entity.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    Long id;

    String title;

    Double rating;

    Integer awards;

    LocalDateTime releaseDate;

    Integer length;

}
