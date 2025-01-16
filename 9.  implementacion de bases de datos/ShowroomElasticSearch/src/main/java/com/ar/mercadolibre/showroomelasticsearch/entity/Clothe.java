package com.ar.mercadolibre.showroom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "clothes")
@AllArgsConstructor
@NoArgsConstructor
public class Clothe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talla;
    private int cantidad;
    @Column(name = "precio_venta")
    private double precioVenta;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_numero", nullable = true)
    private Sale sale;

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

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clothe clothe = (Clothe) o;
        return cantidad == clothe.cantidad && Double.compare(precioVenta, clothe.precioVenta) == 0 && Objects.equals(codigo, clothe.codigo) && Objects.equals(nombre, clothe.nombre) && Objects.equals(tipo, clothe.tipo) && Objects.equals(marca, clothe.marca) && Objects.equals(color, clothe.color) && Objects.equals(talla, clothe.talla) && Objects.equals(sale, clothe.sale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, tipo, marca, color, talla, cantidad, precioVenta, sale);
    }

    @Override
    public String toString() {
        return "Clothe{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", talla='" + talla + '\'' +
                ", cantidad=" + cantidad +
                ", precioVenta=" + precioVenta +
                ", sale=" + sale +
                '}';
    }
}







