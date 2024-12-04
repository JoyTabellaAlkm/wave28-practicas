package ejercicios_integradores.agencia_turismo.service;

import ejercicios_integradores.agencia_turismo.domain.Cliente;
import ejercicios_integradores.agencia_turismo.domain.Localizador;
import ejercicios_integradores.agencia_turismo.domain.reserva.Reservable;
import ejercicios_integradores.agencia_turismo.repository.ClienteRepository;
import ejercicios_integradores.agencia_turismo.repository.LocalizadorRepository;

import java.util.*;
import java.util.stream.Collectors;

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

    public Integer obtenerTotalLocalizadores() {
        return localizadorRepository.obtenerTodos().size();
    }

    public Integer obtenerTotalReservas() {
        return localizadorRepository.obtenerTodos().stream().mapToInt(l -> l.getReservas().size()).sum();
    }

    public Map<String, List<Reservable>> obtenerMapaReservasPorTipo() {
        return localizadorRepository.obtenerTodos().stream()
                .flatMap(l -> l.getReservas().stream())
                .collect(Collectors.groupingBy(Reservable::getTipo));
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

    public Double obtenerTotalVentas() {
        return localizadorRepository.obtenerTodos()
                .stream()
                .mapToDouble(Localizador::getTotal).sum();
    }

    public Double obtenerPromedioTotalVentas() {
        return localizadorRepository.obtenerTodos()
                .stream()
                .mapToDouble(Localizador::getTotal).average().orElse(0.0);
    }
}
