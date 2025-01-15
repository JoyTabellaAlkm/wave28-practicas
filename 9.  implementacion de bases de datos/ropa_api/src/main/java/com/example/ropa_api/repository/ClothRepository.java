package com.example.ropa_api.repository;

import com.example.ropa_api.model.Cloth;
import com.example.ropa_api.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothRepository extends JpaRepository<Cloth, Long> {
    List<Cloth> findAllBySize(String size);

    List<Cloth> findByNameContainingIgnoreCase(String name);

    List<Cloth> findBySales(List<Sale> sales);
}
