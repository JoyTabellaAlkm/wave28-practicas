package com.meli.calculadoraCalorias.dto;

public class IngredientesDto {
    private String name;
    private String calorias;
    private int cantidad;

    public String getName() {
        return name;
    }

    public String getCalorias() {
        return calorias;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
