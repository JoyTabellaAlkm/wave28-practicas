package com.bootcamp.obras_literarias.repository;

import com.bootcamp.obras_literarias.model.Libro;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository extends ElasticsearchRepository<Libro, Integer> {
    List<Libro> findByAutorLastName(String lastName);
    List<Libro> findByTitleContaining(String word);
    List<Libro> findTop5ByOrderByAmountPagesDesc();
    List<Libro> findByReleaseYearBefore(Integer year);
    List<Libro> findByEditorialIgnoreCase(String editorial);
}
