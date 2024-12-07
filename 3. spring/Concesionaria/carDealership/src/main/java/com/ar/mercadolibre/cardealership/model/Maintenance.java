package com.ar.mercadolibre.cardealership.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@NoArgsConstructor
@Data
public class Maintenance {

    private static AtomicLong autoIncrementalId = new AtomicLong(1);
    private Long id;
    private String date;
    private String kilometers;
    private String descriptions;

    public Maintenance(String date, String kilometers, String descriptions) {

        this.id = autoIncrementalId.getAndIncrement();
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }
}
