package org.example.ejercicio_practico_opcional.dto;

import java.util.Date;
import java.util.List;

public class VentaDTO {
    private Date fecha;
    private double total;
    private String medioDePago;
    private List<PrendaDTO> prendas; // Asumiendo que ya tienes PrendaDTO

    // Getters y Setters
    public List<PrendaDTO> getPrendas() {
        return prendas;
    }

    public void setPrendas(List<PrendaDTO> prendas) {
        this.prendas = prendas;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}