package com.lasPerlas.jewerly.repository;

import com.lasPerlas.jewerly.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel,Long> {
}
