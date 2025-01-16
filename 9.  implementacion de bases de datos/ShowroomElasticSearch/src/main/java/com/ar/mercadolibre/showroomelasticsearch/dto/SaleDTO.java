package com.ar.mercadolibre.showroom.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private int numero;
    @JsonFormat(pattern = "dd-MM-yyyy")  // Para serialización (salida del DTO)
    private LocalDate fecha;
    private double total;
    @JsonProperty("medio_de_pago")
    @NotEmpty(message = "Se debe proporcionar un medio de pago")
    private String medioDePago;
    @JsonProperty("lista_de_prendas")
    @NotEmpty(message = "La venta debe tener por lo menos una prenda")
    private List< @Valid ClotheDTO> listaDePrendas;

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

    public List<ClotheDTO> getListaDePrendas() {
        return listaDePrendas;
    }

    public void setListaDePrendas(List<ClotheDTO> listaDePrendas) {
        this.listaDePrendas = listaDePrendas;
    }

    @Override
    public String toString() {
        return "SaleDTO{" +
                "numero=" + numero +
                ", fecha=" + fecha +
                ", total=" + total +
                ", medioDePago='" + medioDePago + '\'' +
                ", listaDePrendas=" + listaDePrendas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SaleDTO saleDTO = (SaleDTO) o;
        return numero == saleDTO.numero && Double.compare(total, saleDTO.total) == 0 && Objects.equals(fecha, saleDTO.fecha) && Objects.equals(medioDePago, saleDTO.medioDePago) && Objects.equals(listaDePrendas, saleDTO.listaDePrendas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, fecha, total, medioDePago, listaDePrendas);
    }
}
