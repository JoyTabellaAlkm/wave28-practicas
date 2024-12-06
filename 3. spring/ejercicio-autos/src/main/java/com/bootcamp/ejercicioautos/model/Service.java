package com.bootcamp.ejercicioautos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;


@AllArgsConstructor
@Data
public class Service {
    private static AtomicLong autoIncrementalId = new AtomicLong(1);
    private Long id;
    private String date;
    private String kilometers;
    private String descriptions;

    public Service(String date, String kilometers, String descriptions) {
        this.id = autoIncrementalId.getAndIncrement();
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }
}
