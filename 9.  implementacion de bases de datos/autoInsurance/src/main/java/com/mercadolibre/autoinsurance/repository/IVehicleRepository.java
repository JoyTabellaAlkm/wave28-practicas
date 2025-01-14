package com.mercadolibre.autoinsurance.repository;

import com.mercadolibre.autoinsurance.dto.response.PatentBrandAndModelResponseDto;
import com.mercadolibre.autoinsurance.dto.response.PatentBrandResponseDto;
import com.mercadolibre.autoinsurance.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v.patent " +
            "FROM Vehicle v")
    List<String> findAllPatents();

    @Query("SELECT new com.mercadolibre.autoinsurance.dto.response.PatentBrandResponseDto(v.patent, v.brand) " +
            "FROM Vehicle v " +
            "ORDER BY v.yearOfManufacture DESC")
    List<PatentBrandResponseDto> findAllPatentsAndBrandOrderByYearOfManufacture();

    @Query("SELECT v.patent " +
            "FROM Vehicle v " +
            "WHERE v.numberOfWheels > 4 AND v.yearOfManufacture = :currentYear")
    List<String> findAllByNumberOfWheelsAndYearOfManufacture(@Param("currentYear") Short currentYear);

    @Query("SELECT new com.mercadolibre.autoinsurance.dto.response.PatentBrandAndModelResponseDto(v.patent, v.brand, v.model)" +
            "FROM Vehicle v " +
            "JOIN v.accidents a " +
            "WHERE a.economicLoss > 10000")
    List<PatentBrandAndModelResponseDto> findAllPatentBrandAndModelByEconomicLoss();

    @Query("SELECT v, SUM(a.economicLoss) " +
            "FROM Vehicle v " +
            "JOIN v.accidents a " +
            "WHERE a.economicLoss > 10000 " +
            "GROUP BY v")
    List<Object[]> findVehiclesByEconomicLoss();
}
