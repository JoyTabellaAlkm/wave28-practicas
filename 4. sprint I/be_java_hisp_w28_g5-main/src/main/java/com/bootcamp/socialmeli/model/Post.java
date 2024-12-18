package com.bootcamp.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post {
    @EqualsAndHashCode.Include
    private Long id;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private Double discount;
}
