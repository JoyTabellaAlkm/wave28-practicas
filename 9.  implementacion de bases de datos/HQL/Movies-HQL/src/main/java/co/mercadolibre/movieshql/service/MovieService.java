package co.mercadolibre.movieshql.service;

import co.mercadolibre.movieshql.dto.ResponseMovieActorsDto;
import co.mercadolibre.movieshql.respository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    IMovieRepository movieRepository;

    public ResponseMovieActorsDto getMovieActors(String movie){
        return new ResponseMovieActorsDto(HttpStatus.OK.value(),
                movieRepository.findAllByTitle(movie));
    }
}
