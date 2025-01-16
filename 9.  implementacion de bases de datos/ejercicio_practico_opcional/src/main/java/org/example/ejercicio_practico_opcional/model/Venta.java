package org.example.ejercicio_practico_opcional.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double total;
    private String medioDePago;

    @ManyToMany(cascade = CascadeType.ALL) // Cascade para que las prendas se manejen automáticamente
    @JoinTable(
            name = "venta_prenda", // Tabla intermedia
            joinColumns = @JoinColumn(name = "venta_id"), // Clave foránea para Venta
            inverseJoinColumns = @JoinColumn(name = "prenda_id") // Clave foránea para Prenda
    )
    private List<Prenda> prendas;

    public List<Prenda> getPrendas() {
        return prendas;
    }

    public void setPrendas(List<Prenda> prendas) {
        this.prendas = prendas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

}
