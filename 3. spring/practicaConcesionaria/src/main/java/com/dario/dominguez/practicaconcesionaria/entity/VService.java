package com.dario.dominguez.practicaconcesionaria.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private String kilometers;
    private String descriptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}

