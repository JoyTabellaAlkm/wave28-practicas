package com.example.showroom.dto;

import com.example.showroom.entity.Prenda;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class VentaDto {
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate fecha;
    Double total;
    @JsonProperty("medio_pago")
    String medioPago;
    List<Prenda> prendas;
}
