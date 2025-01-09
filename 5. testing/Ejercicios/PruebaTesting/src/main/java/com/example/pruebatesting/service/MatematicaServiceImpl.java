package com.example.pruebatesting.service;


import org.springframework.stereotype.Service;

@Service
public class MatematicaServiceImpl implements IMatematicaService{
    @Override
    public int sumar(int a, int b) {
        return a + b;
    }
}
