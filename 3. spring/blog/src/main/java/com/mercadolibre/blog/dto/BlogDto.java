package com.mercadolibre.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private Integer id;
    private String title;
    private String author;
    private LocalDate publicationDate;
}
