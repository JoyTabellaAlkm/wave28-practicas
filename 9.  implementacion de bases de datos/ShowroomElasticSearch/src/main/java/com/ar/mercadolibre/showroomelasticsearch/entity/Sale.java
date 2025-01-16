package com.ar.mercadolibre.showroom.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sales")
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private LocalDate fecha;
    private double total;
    @Column(name = "medio_de_pago")
    private String medioDePago;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Clothe> listaDePrendas;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public List<Clothe> getListaDePrendas() {
        return listaDePrendas;
    }

    public void setListaDePrendas(List<Clothe> listaDePrendas) {
        this.listaDePrendas = listaDePrendas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return numero == sale.numero && Double.compare(total, sale.total) == 0 && Objects.equals(fecha, sale.fecha) && Objects.equals(medioDePago, sale.medioDePago) && Objects.equals(listaDePrendas, sale.listaDePrendas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, fecha, total, medioDePago, listaDePrendas);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "numero=" + numero +
                ", fecha=" + fecha +
                ", total=" + total +
                ", medioDePago='" + medioDePago + '\'' +
                ", listaDePrendas=" + listaDePrendas +
                '}';
    }
}
