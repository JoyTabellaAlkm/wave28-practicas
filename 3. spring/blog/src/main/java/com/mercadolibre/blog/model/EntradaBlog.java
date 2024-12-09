package com.mercadolibre.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntradaBlog that)) return false;
        return Objects.equals(getTitulo(), that.getTitulo()) && Objects.equals(getNombreAutor(), that.getNombreAutor()) && Objects.equals(getFechaPublicacion(), that.getFechaPublicacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getNombreAutor(), getFechaPublicacion());
    }
}
