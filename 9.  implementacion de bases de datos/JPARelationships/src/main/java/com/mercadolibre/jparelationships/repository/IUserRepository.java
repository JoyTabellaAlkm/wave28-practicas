package com.mercadolibre.jparelationships.repository;

import com.mercadolibre.jparelationships.entity.oneToOne.unidirectional.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
