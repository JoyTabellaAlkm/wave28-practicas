package com.ejercicios.linktracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkModel {
    private int id;
    private String url;
    private int counter;
}
