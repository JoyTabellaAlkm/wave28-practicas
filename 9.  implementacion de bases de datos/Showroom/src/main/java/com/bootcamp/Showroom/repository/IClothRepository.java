package com.bootcamp.Showroom.repository;

import com.bootcamp.Showroom.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IClothRepository extends JpaRepository<Cloth,Long> {
    Cloth findByCode(Integer code);

    void deleteByCode(Integer code);

    List<Cloth> findClothsBySize(String size);

    List<Cloth> findClothsByName(String name);
}
