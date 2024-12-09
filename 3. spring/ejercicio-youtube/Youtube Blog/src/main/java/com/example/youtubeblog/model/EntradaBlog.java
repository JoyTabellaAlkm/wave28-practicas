package com.example.youtubeblog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
public class EntradaBlog {
    @NotNull
    private String idBlog;
    @NotNull
    private String titulo;
    @NotNull
    private String nombreAutor;
    @NotNull
    private String fechaPublicacion;
}
