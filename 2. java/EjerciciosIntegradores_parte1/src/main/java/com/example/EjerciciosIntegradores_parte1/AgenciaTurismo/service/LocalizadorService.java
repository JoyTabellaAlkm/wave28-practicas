package com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.service;

import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.domain.Cliente;
import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.domain.Localizador;
import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.repository.ClienteRepository;
import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.repository.LocalizadorRepository;

public class LocalizadorService {
    private ClienteRepository clienteRepository;
    private LocalizadorRepository localizadorRepository;

    public LocalizadorService(ClienteRepository clienteRepository, LocalizadorRepository localizadorRepository) {
        this.clienteRepository = clienteRepository;
        this.localizadorRepository = localizadorRepository;
    }

    public Double calcularPrecioFinal(Localizador localizador) {
        if(aplicaDescuentoPorLealtad(localizador.getCliente())) {
            return localizador.getTotal() * 0.95;
        }
        return localizador.getTotal();
    }

    private boolean aplicaDescuentoPorLealtad(Cliente cliente) {
        if(cliente != null) {
            return localizadorRepository.obtenerTodos()
                    .stream()
                    .filter(l -> l.getCliente() == cliente)
                    .count() >= 2;
        }
        return false;
    }
}
