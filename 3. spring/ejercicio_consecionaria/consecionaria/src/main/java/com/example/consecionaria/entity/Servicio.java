package com.example.consecionaria.entity;

import java.time.LocalDate;

public class Servicio {
    private LocalDate date;
    private double kilometers;
    private String descriptions;

    public Servicio(LocalDate date, double kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }

    public Servicio() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
