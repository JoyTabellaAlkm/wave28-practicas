package com.mercadolibre.jparelationships.repository;

import com.mercadolibre.jparelationships.entity.manyToMany.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
}
