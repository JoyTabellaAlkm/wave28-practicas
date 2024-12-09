package com.mercadolibre.CarDealer.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ServiceDTO {
    private Date date;
    private int kilometers;
    private String description;

    public ServiceDTO() {
    }

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

    public ServiceDTO(Date date, int kilometers, String description) {
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }
}
