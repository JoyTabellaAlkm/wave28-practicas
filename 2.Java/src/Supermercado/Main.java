package Supermercado;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Supermercado superDia= new Supermercado();

        Cliente cliente1= new Cliente("12345678","Juana", "Perez");
        Cliente cliente2= new Cliente("11111111","Perla", "Jaime");
        Cliente cliente3= new Cliente("87654321","Carlos", "Ruiz");

        Item pan= new Item(1, "pan",2,300.0);
        Item arroz= new Item(2, "arroz",1,400.0);
        Item fideo= new Item(3, "fideo",4,800.0);
        Item dulce= new Item(4, "dulce",2,300.0);

        superDia.agregarCliente(cliente1);
        superDia.agregarCliente(cliente2);
        superDia.agregarCliente(cliente3);

        List<Item> items1= List.of(pan,arroz,fideo);
        List<Item> items2= List.of(dulce,pan);
        List<Item> items3= List.of(dulce);

        Factura fac1= new Factura(cliente1,items1);
        Factura fac2= new Factura(cliente2,items2);
        Factura fac3= new Factura(cliente1,items3);

        System.out.println("----------- CLIENTE SUPER --------------");
        superDia.getClientes();
        superDia.agregarFacturaACliente(cliente1, fac1);
        superDia.agregarFacturaACliente(cliente2, fac2);
        superDia.agregarFacturaACliente(cliente1, fac3);

        System.out.println("--------------- MUESTRA LISTA DE CLIENTES CON SUS FACTURAS -------");
        superDia.mostrarListaClienteFactura();


        superDia.eliminarCliente(cliente3);
        System.out.println("----------- CLIENTE BORRADO --------------");
        superDia.getClientes();

        System.out.println("----------- MOSTRAR CLIENTE POR DNI --------------");
        superDia.mostrarCliente("12345678");
        superDia.mostrarCliente("22222222");
    }
}
