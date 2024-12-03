package com.example.EjerciciosIntegradores_parte1.AgenciaTurismo;
import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.domain.Cliente;
import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.domain.Localizador;
import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.domain.reserva.ReservaGenerica;
import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.repository.*;
import com.example.EjerciciosIntegradores_parte1.AgenciaTurismo.service.LocalizadorService;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteRepository();
        LocalizadorRepository localizadorRepository = new LocalizadorRepository();
        LocalizadorService localizadorService = new LocalizadorService(clienteRepository, localizadorRepository);

        Cliente cliente1 = new Cliente("Lucas", "Caraballo", "44222666", "1166554433");
        Cliente cliente2 = new Cliente("Matias", "Caraballo", "42334582", "1166554502");
        clienteRepository.crear(cliente1);
        clienteRepository.crear(cliente2);

        Localizador localizador1 = new Localizador(cliente1);
        Localizador localizador2 = new Localizador(cliente1);
        Localizador localizador3 = new Localizador(cliente1);

        // Creo un nuevo localizador
        localizador1.agregarReserva(new ReservaGenerica(1, 5000.0, "hotel"));
        localizador1.agregarReserva(new ReservaGenerica(1, 4000.0, "transporte"));
        localizador1.agregarReserva(new ReservaGenerica(1, 3000.0, "comida"));
        localizador1.agregarReserva(new ReservaGenerica(1, 15000.0, "boleto"));

        // Imprimo el localizador creado y sus precios
        System.out.println("\n" + localizador1);
        System.out.println("Precio localizador: " + localizador1.getTotal());
        System.out.println("Con descuento por fidelidad: " + localizadorService.calcularPrecioFinal(localizador1));
        localizadorRepository.crear(localizador1);

        // Creo un nuevo localizador
        localizador2.agregarReserva(new ReservaGenerica(2, 5000.0, "hotel"));
        localizador2.agregarReserva(new ReservaGenerica(2, 15000.0, "boleto"));

        // Imprimo el localizador creado y sus precios
        System.out.println("\n" + localizador2);
        System.out.println("Precio localizador: " + localizador2.getTotal());
        System.out.println("Con descuento por fidelidad: " + localizadorService.calcularPrecioFinal(localizador2));
        localizadorRepository.crear(localizador2);

        // Creo un nuevo localizador
        localizador3.agregarReserva(new ReservaGenerica(1, 5000.0, "comida"));

        // Imprimo el localizador creado y sus precios
        System.out.println("\n" + localizador3);
        System.out.println("Precio localizador: " + localizador3.getTotal());
        System.out.println("Con descuento por fidelidad: " + localizadorService.calcularPrecioFinal(localizador3));
        localizadorRepository.crear(localizador3);

        // Creo un nuevo localizador
        Localizador localizador4 = new Localizador(cliente2);
        localizador4.agregarReserva(new ReservaGenerica(2, 5000.0, "hotel"));

        // Imprimo el localizador creado y sus precios
        System.out.println("\n" + localizador4);
        System.out.println("Precio localizador: " + localizador4.getTotal());
        System.out.println("Con descuento por fidelidad: " + localizadorService.calcularPrecioFinal(localizador4));
        localizadorRepository.crear(localizador4);


    }
}
