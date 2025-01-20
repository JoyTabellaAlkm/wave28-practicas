package co.mercadolibre.movieshql.service;

import co.mercadolibre.movieshql.config.ModelMapperConfig;
import co.mercadolibre.movieshql.dto.ResponseActorFavoriteMovieDto;
import co.mercadolibre.movieshql.dto.ResponseActorRatingDto;
import co.mercadolibre.movieshql.respository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    @Autowired
    IActorRepository actorRepository;

    private final ModelMapper modelMapper;

    public ActorService() {
        this.modelMapper = ModelMapperConfig.getModelMapper();
    }

    public ResponseActorFavoriteMovieDto getActorsWithFavoriteMovie(){
        return new ResponseActorFavoriteMovieDto(HttpStatus.OK.value(),
                actorRepository.findAllByFavoriteMovieIsNotNull());
    }

    public ResponseActorRatingDto getActorsWithParamRating(Double param) {
        return new ResponseActorRatingDto(HttpStatus.OK.value(),
                actorRepository.findAllByRatingGreaterThan(param));
    }
}
