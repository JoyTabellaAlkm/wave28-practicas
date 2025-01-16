package com.ar.mercadolibre.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClotheDTO {

    private Long codigo;
    @NotEmpty(message = "Se debe proveer un nombre a la prenda")
    private String nombre;
    @NotEmpty(message = "Se debe proveer un tipo de prenda")
    private String tipo;
    @NotEmpty(message = "Se debe proveer una marca de prenda")
    private String marca;
    @NotEmpty(message = "Se debe proveer un color de prenda")
    private String color;
    @NotEmpty(message = "Se debe proveer una talla de prenda")
    private String talla;
    @Min(value = 1, message = "La cantidad debe ser mayor a cero")
    private int cantidad;
    @JsonProperty("precio_venta")
    @Min(value = 1, message = "El precio debe ser mayor a cero")
    private double precioVenta;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "ClotheDTO{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", talla='" + talla + '\'' +
                ", cantidad=" + cantidad +
                ", precioVenta=" + precioVenta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClotheDTO clotheDTO = (ClotheDTO) o;
        return cantidad == clotheDTO.cantidad && Double.compare(precioVenta, clotheDTO.precioVenta) == 0 && Objects.equals(codigo, clotheDTO.codigo) && Objects.equals(nombre, clotheDTO.nombre) && Objects.equals(tipo, clotheDTO.tipo) && Objects.equals(marca, clotheDTO.marca) && Objects.equals(color, clotheDTO.color) && Objects.equals(talla, clotheDTO.talla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, tipo, marca, color, talla, cantidad, precioVenta);
    }
}
