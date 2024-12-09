package com.mercadolibre.CarDealer.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ServiceEntity {
    private Date date;
    private int kilometers;
    private String description;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceEntity() {
    }

    public ServiceEntity(Date date, int kilometers, String description) {
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }
}
