package org.example.lasperlasjoyeria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String material;
    double peso;
    String particularidad;
    boolean posee_piedra;
    boolean ventaONo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getParticularidad() {
        return particularidad;
    }

    public void setParticularidad(String particularidad) {
        this.particularidad = particularidad;
    }

    public boolean isPosee_piedra() {
        return posee_piedra;
    }

    public void setPosee_piedra(boolean posee_piedra) {
        this.posee_piedra = posee_piedra;
    }

    public boolean isVentaONo() {
        return ventaONo;
    }

    public void setVentaONo(boolean ventaONo) {
        this.ventaONo = ventaONo;
    }
}
