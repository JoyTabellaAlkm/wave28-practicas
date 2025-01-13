package com.example.JoyeriaLasPerlas.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDto {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;

    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
    private boolean ventaONo = true;
}
