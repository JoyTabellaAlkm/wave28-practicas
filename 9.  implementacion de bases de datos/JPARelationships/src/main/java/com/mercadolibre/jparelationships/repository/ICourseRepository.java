package com.mercadolibre.jparelationships.repository;

import com.mercadolibre.jparelationships.entity.manyToMany.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
}
