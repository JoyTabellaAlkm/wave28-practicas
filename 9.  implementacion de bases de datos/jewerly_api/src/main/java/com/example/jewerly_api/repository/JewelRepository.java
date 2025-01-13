package com.example.jewerly_api.repository;

import com.example.jewerly_api.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Long> {
    Optional<Jewel> findByIdAndCanSell(Long id, Boolean canSell);

    List<Jewel> findAllByCanSell(Boolean canSell);
}
