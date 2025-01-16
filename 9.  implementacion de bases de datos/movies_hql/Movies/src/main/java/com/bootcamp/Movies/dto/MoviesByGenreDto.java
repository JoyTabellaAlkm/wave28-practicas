package com.bootcamp.Movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoviesByGenreDto {
    String genre;
    List<String> movies;
}
