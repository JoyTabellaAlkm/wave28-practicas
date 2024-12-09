package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO {
    private int id;
    private String title;
    private String authorName;
    private LocalDate publicationDate;
}
