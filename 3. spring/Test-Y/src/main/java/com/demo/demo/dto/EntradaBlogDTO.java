package com.demo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class EntradaBlogDTO {
    private Integer id;
    private String titulo;
    private String nombre;
    private String fechaPublicacion; // formato dd/mm/aa
}
