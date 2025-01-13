package com.mercadolibre.jparelationships.repository;

import com.mercadolibre.jparelationships.entity.oneToOne.bidirectional.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, Long> {
}
