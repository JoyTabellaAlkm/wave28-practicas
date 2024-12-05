package com.demo.demo.service;

import java.time.LocalDate;

public interface ICalculadorDeEdadService {
    public int calcularEdad(LocalDate fechaDeNacimiento);
}