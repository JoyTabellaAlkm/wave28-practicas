package com.melibootcamp.sportsmen.repositories;

import com.melibootcamp.sportsmen.entities.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport,Long> {
}
