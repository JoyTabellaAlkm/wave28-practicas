package com.melibootcamp.qatesters.repository;

import com.melibootcamp.qatesters.entity.TestCase;
import com.melibootcamp.qatesters.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
