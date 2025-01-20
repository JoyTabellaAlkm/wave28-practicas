package co.mercadolibre.movieshql.dto;

import co.mercadolibre.movieshql.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMovieActorsDto {
    Integer status;
    List<Movie> movies;
}
