package com.example.Ejercicio_LinkTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {

    private int linkId;
    private String url;
    private String password;
    private int redirectionCount;

}
