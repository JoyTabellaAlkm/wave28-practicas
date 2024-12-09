package com.mercadolibre.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer id;
    private String title;
    private String author;
    private LocalDate publicationDate;
}
