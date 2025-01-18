package org.example.lasperlasjoyeria.dto;

public class JoyaDTO {
    String nombre;
    String material;
    double peso;
    String particularidad;
    boolean posee_piedra;
    boolean ventaONo;

    public boolean isVentaONo() {
        return ventaONo;
    }

    public void setVentaONo(boolean ventaONo) {
        this.ventaONo = ventaONo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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
}
