import CRUD.ClienteCRUD;
import CRUD.FacturaCRUD;
import Clases.Cliente;
import Clases.Factura;
import Clases.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClienteCRUD cCrud = new ClienteCRUD();
        FacturaCRUD fCrud = new FacturaCRUD();

        List<Cliente> listaClientes = new ArrayList<>();
        List<Factura> listaFacturas = new ArrayList<>();

        // region [Category: Clientes]

        // Crear Clientes
        Cliente c = cCrud.create();
        System.out.println();
        Cliente c2 = cCrud.create();
        System.out.println();
        Cliente c3 = cCrud.create();

        listaClientes.add(c);
        listaClientes.add(c2);
        listaClientes.add(c3);

        // Listar todos los Clientes
        System.out.println();
        cCrud.listarTodos(listaClientes);

        // Eliminar Cliente
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Cliente a eliminar");
        int dni = sc.nextInt();
        cCrud.delete(listaClientes,dni);

        // Listar todos los Clientes
        System.out.println();
        cCrud.listarTodos(listaClientes);

        // Buscar x dni
        System.out.println();
        System.out.println("Ingrese DNI a buscar");
        int dni2 = sc.nextInt();
        Cliente cl = cCrud.buscar(listaClientes,dni2);
        if (cl != null){
            System.out.println(cl.toString());
        }else {
            System.out.println("No existe el cliente con DNI: "+ dni2);
        }

        // endregion [Category: Clientes]

        // region [Category: Facturas]

        // Crear Factura
        Factura factura = fCrud.create();
        System.out.println("Ingrese DNI del Cliente a agregar a la factura");
        int dni3 = sc.nextInt();
        Cliente clieFac = cCrud.buscar(listaClientes,dni3);
        if(clieFac != null){
            factura.setCliente(clieFac);
        }else {
            System.out.println("El cliente no existe, Creando...");
            Cliente cNuevo = cCrud.create();
            factura.setCliente(cNuevo);
        }

        List<Item> listaProductos = List.of(new Item(100, 3, "Cafe", 1),
                new Item(200, 1, "Carne", 2),
                new Item(300, 4, "Fideos", 3));

        double total = 0.0;
        for(Item i : listaProductos){
            total += i.getPrecioUnitario()*i.getCantidadComprada();
        }

        factura.setCarrito(listaProductos);
        factura.setTotalCompra(total);

        listaFacturas.add(factura);

        fCrud.listarTodos(listaFacturas);

        // rendegion [Category: Facturas]
    }
}