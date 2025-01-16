package com.mercadolibre.movies_hql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mercadolibre.movies_hql.entity.Serie;

public interface ISerieRepository extends JpaRepository<Serie, Integer> {

    @Query("SELECT s FROM Serie s INNER JOIN Season se ON s = se.serie WHERE se.number > ?1")
    public List<Serie> findAllBySeasonQuantityUp(int quantitySeason);

}
