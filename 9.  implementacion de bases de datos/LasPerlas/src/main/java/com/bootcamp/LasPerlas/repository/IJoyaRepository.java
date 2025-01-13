package com.bootcamp.LasPerlas.repository;
import com.bootcamp.LasPerlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoyaRepository extends JpaRepository <Joya, Long> {
    public List<Joya> findAllByVentaONoIsTrue ();
    public List<Joya> findAllByMaterialAndVentaONoIsTrue(String material);
}
