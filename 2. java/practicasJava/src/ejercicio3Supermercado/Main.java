package ejercicio3Supermercado;

import ejercicio3Supermercado.CRUD.ClienteImp;
import ejercicio3Supermercado.CRUD.FacturaImp;
import ejercicio3Supermercado.CRUD.ProductoImp;
import ejercicio3Supermercado.model.Cliente;
import ejercicio3Supermercado.model.Factura;
import ejercicio3Supermercado.model.Producto;

import java.util.*;

public class Main {
    public static void main(String[] args){
        ClienteImp clienteImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();
        ProductoImp productoImp = new ProductoImp();

        Cliente cliente1 = new Cliente(43567845L,"Juan","Abarca");
        Cliente cliente2 = new Cliente(34896457L,"Pedro","Vecchio");
        Cliente cliente3 = new Cliente(23456823L,"Alfonsina", "Roman");
        Cliente cliente4 = new Cliente(95003773L,"Gonza", "Roman");

        clienteImp.crearInstancia(cliente1);
        clienteImp.crearInstancia(cliente2);
        clienteImp.crearInstancia(cliente3);
        clienteImp.crearInstancia(cliente4);

        //Se muestran los clientes
        clienteImp.mostrarInstancias();
        System.out.println("------------------------");

        //Se elimina un cliente
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un DNI para eliminar en la base de datos:");
        Long dniBorrado = teclado.nextLong();
        clienteImp.eliminarInstancia(dniBorrado);

        //Ingresar DNI y buscar
        System.out.println("Ingrese un DNI para buscar en la base de datos:");
        Long dniBuscado = teclado.nextLong();
        clienteImp.consultarInstancia(dniBuscado);
        System.out.println("------------------------");


        //Parte 2 -- Facturas
        //Se crean productos
        Producto producto1 = new Producto("0001","Barrita Cereal", 12, 340);
        Producto producto2 = new Producto("0002", "Yerba mate Playadito 1kg",  6, 4000);
        productoImp.crearInstancia(producto1);
        productoImp.crearInstancia(producto2);
        //
        System.out.println("Ingrese un DNI para ingresar en la factura:");
        Long dniFactura = teclado.nextLong();

        //crear factura
        List<Producto> listaProductos= List.of(producto1, producto2);
        if (clienteImp.consultarInstancia(dniFactura).isEmpty()){
            System.out.println("Ingrese su nombre:");
            String nombre = teclado.next();
            System.out.println("Ingrese su Apellido:");
            String apellido = teclado.next();
            Cliente cliente = new Cliente(dniFactura,nombre,apellido);
            clienteImp.crearInstancia(cliente);
            Factura factura = new Factura(cliente,listaProductos,0);
            facturaImp.crearInstancia(factura);

        } else{
            Factura factura = new Factura(clienteImp.consultarInstancia(dniFactura).get(),listaProductos,0);
            facturaImp.crearInstancia(factura);
        }

        facturaImp.mostrarInstancias();
    }
}
