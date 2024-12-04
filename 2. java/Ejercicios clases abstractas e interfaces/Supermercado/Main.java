package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        List<Factura> facturas = new ArrayList<>();

        Cliente cliente1 = new Cliente("lucas", "bianchi", "42822180");
        Cliente cliente2 = new Cliente("lionel", "messi", "42822555");
        Cliente cliente3 = new Cliente("diego", "maradona", "42822456");

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        for (Cliente cliente: clientes) {
            System.out.println(cliente);
        }

//        Scanner scanner = new Scanner(System.in);
//        String nombre = scanner.next();
//        List<Cliente> nuevaListaUsuarios = new ArrayList<>();
//        for (Cliente cliente: clientes) {
//            if(!cliente.getNombre().equals(nombre)){
//                nuevaListaUsuarios.add(cliente);
//            }
//        }
//        clientes = nuevaListaUsuarios;
//
//        System.out.println("nueva lista de clientes");
//        for (Cliente cliente: clientes) {
//            System.out.println(cliente);
//        }

//        segunda parte

        System.out.println("validar si cliente exite para agregar");
        String dniTrue="42822180";
        String dniFalse= "42880";

        boolean existeCliente = clientes.stream().anyMatch(c -> c.getDni().equals(dniTrue));

        if(existeCliente){
            for (Cliente cliente: clientes) {
                if (cliente.getDni().equals(dniTrue)) {
                    System.out.println("existe usuario, se agrega factura");
                    List<Items> items = List.of(new Items(1, "compra1", 2, 300));
                    Factura factura = new Factura(cliente, items);
                    int costoItems = items.stream().mapToInt(i -> i.getCosto()).sum();
                    factura.setTotal(costoItems);
                    facturas.add(factura);
                }
            }
        }else{
            System.out.println("no existe usuario en db, primero se crea y despues se agrega factura");
            Cliente cliente5 = new Cliente("lucas", "bianchi", "42822180");
            clientes.add(cliente5);
            List<Items> items = List.of(new Items(1,"compra1",2,300));
            Factura factura = new Factura(cliente5,items);
            int costoItems = items.stream().mapToInt(i->i.getCosto() * i.getCant()).sum();
            factura.setTotal(costoItems);
            facturas.add(factura);
        }


        System.out.println("mostrar facturas");
        for (Factura f:facturas) {
            System.out.println(facturas);
        };











    }
}