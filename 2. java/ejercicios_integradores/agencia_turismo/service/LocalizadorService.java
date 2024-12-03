package ejercicios_integradores.agencia_turismo.service;

import ejercicios_integradores.agencia_turismo.domain.Cliente;
import ejercicios_integradores.agencia_turismo.domain.Localizador;
import ejercicios_integradores.agencia_turismo.repository.ClienteRepository;
import ejercicios_integradores.agencia_turismo.repository.LocalizadorRepository;

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
