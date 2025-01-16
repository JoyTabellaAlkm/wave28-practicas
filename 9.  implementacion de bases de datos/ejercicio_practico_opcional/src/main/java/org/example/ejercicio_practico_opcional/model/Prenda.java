package org.example.ejercicio_practico_opcional.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "prendas")
public class Prenda {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long codigo;
 private String nombre;
 private String tipo;
 private String marca;
 private String color;
 private String talle;
 private int cantidad;
 private double precio_venta;

 @ManyToMany(mappedBy = "prendas") // Mapeada por la lista de prendas en Venta
 private List<Venta> ventas;

 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 public double getPrecio_venta() {
  return precio_venta;
 }

 public void setPrecio_venta(double precio_venta) {
  this.precio_venta = precio_venta;
 }

 public int getCantidad() {
  return cantidad;
 }

 public void setCantidad(int cantidad) {
  this.cantidad = cantidad;
 }

 public String getTalle() {
  return talle;
 }

 public void setTalle(String talle) {
  this.talle = talle;
 }

 public String getColor() {
  return color;
 }

 public void setColor(String color) {
  this.color = color;
 }

 public String getMarca() {
  return marca;
 }

 public void setMarca(String marca) {
  this.marca = marca;
 }

 public String getTipo() {
  return tipo;
 }

 public void setTipo(String tipo) {
  this.tipo = tipo;
 }

 public Long getCodigo() {
  return codigo;
 }

 public void setCodigo(Long codigo) {
  this.codigo = codigo;
 }


}


