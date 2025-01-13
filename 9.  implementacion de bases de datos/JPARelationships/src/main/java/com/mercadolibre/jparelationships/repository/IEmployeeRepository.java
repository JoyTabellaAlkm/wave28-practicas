package com.mercadolibre.jparelationships.repository;

import com.mercadolibre.jparelationships.entity.oneToOne.bidirectional.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
