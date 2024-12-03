package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

//    Una agencia de viajes premia a sus viajeros con descuentos cuando desean adquirir algún paquete turístico,
//    el cual consiste en reservas de hotel, comida, boletos de viajes y transporte. Las reservas son almacenadas en localizadores, los cuales contienen los datos del cliente, el total y la reserva o varias reservas dependiendo del producto adquirido. Por tanto los descuentos se aplicarán cuando:
//
//    Si un cliente anteriormente adquirió al menos 2 localizadores, se le descontará un 5% del total para futuras compras.
//    Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
//    Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.
//    Al momento de generar el localizador se debe almacenar en una clase repositorio y se imprimirá el mismo con los detalles d
//    e la compra.
//
//    Se requiere crear un repositorio cliente, para así poder buscar las reservas anteriores del cliente y aplicar descuentos;
//    en caso de no existir el cliente poder agregarlo al repositorio cliente.
    public static void main(String[] args) {
        RepositorioCliente repositorioCliente = new RepositorioCliente();


        List<Reserva> listaReservas = new ArrayList<>(
                List.of(new Hotel(300),
                new Comida(600),
                new Transporte(700),
                new BoletoViaje(200))
        );

        Cliente cliente1 = new Cliente("Manolo", "Sanchez", "333333");
        Localizador localizador1 = new Localizador(listaReservas, cliente1);

//        punto1
        System.out.println(localizador1);

//        punto2
        List<Reserva> listaReservas2 = new ArrayList<>(List.of(new Hotel(1200),new Hotel(400), new BoletoViaje(350), new BoletoViaje(650)));

        Localizador localizador2 = new Localizador(listaReservas2, cliente1);
        System.out.println(localizador2);

//        punto 3
        List<Reserva> listaReservas3 = new ArrayList<>(List.of(new Hotel(1500)));
        Localizador localizador3 = new Localizador(listaReservas3, cliente1);


//      punto 4

        repositorioCliente.agregarLocalizador(localizador1);
        repositorioCliente.agregarLocalizador(localizador2);
        repositorioCliente.agregarLocalizador(localizador3);

        System.out.println("prueba");
        repositorioCliente.aplicarDescuentosPorCliente(cliente1);



    }
}