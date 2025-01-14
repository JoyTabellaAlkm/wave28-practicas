package com.bootcamp.LasPerlas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelResponse {
    private String message;
    private int status;
}
