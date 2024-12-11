package com.mercadoLibre.concesionariaAutos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceEntity {
    private AtomicLong automaticId = new AtomicLong(1);
    private Long id;
    private String date;
    private String kilometers;
    private String descriptions;

    public ServiceEntity(String date, String kilometers, String descriptions) {
        this.id = automaticId.getAndIncrement();
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
        this.automaticId = automaticId;
    }
}
