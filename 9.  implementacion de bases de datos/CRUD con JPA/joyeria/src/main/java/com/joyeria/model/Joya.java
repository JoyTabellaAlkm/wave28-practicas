package com.joyeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String material;
    Double peso;
    String particularidad;
    Boolean poseePiedra;
    Boolean ventaONo;

    public Joya() {
    }

    public Joya(String name, String material, Double peso, String particularidad, Boolean poseePiedra, Boolean ventaONo) {
        this.name = name;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.poseePiedra = poseePiedra;
        this.ventaONo = ventaONo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getParticularidad() {
        return particularidad;
    }

    public void setParticularidad(String particularidad) {
        this.particularidad = particularidad;
    }

    public Boolean getPoseePiedra() {
        return poseePiedra;
    }

    public void setPoseePiedra(Boolean poseePiedra) {
        this.poseePiedra = poseePiedra;
    }

    public Boolean getVentaONo() {
        return ventaONo;
    }

    public void setVentaONo(Boolean ventaONo) {
        this.ventaONo = ventaONo;
    }
}
