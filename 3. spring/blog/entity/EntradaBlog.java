package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private int id;
    private String title;
    private String authorName;
    private LocalDate publicationDate;
}
