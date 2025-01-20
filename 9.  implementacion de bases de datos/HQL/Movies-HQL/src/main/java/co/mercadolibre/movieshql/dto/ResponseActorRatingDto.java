package co.mercadolibre.movieshql.dto;

import co.mercadolibre.movieshql.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseActorRatingDto {
    Integer status;
    List<Actor> actors;
}
