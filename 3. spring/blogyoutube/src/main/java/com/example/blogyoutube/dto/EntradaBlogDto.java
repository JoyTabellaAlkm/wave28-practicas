package com.example.blogyoutube.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlogDto {
    private long id;
    private String title;
    private String author;
    private String date;
}
