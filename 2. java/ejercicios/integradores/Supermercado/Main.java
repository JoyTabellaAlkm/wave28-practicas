package ejercicios.integradores.Supermercado;

import ejercicios.integradores.Supermercado.implementaciones.ClienteImp;
import ejercicios.integradores.Supermercado.implementaciones.FacturaImp;
import ejercicios.integradores.Supermercado.implementaciones.ItemImpl;
import ejercicios.integradores.Supermercado.modelo.Cliente;
import ejercicios.integradores.Supermercado.modelo.Facturas;
import ejercicios.integradores.Supermercado.modelo.Item;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //Creacion clases implementacion
        ClienteImp clienteImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();
        ItemImpl itemImple = new ItemImpl();

        //PARTE 1
        //Creacion de clientes
        Cliente cliente1 = new Cliente(4098263, "carolina", "schwab");
        Cliente cliente2 = new Cliente(4098863, "Mariana", "Rodriguez");
        Cliente cliente3 = new Cliente(4098663, "Luciana", "Gomez");
        Cliente cliente4 = new Cliente(4098603, "Emilio", "Suarez");

        clienteImp.save(cliente1);
        clienteImp.save(cliente2);
        clienteImp.save(cliente3);

        System.out.println("Listado de clientes completos");
        for(Cliente cli : clienteImp.listar()){
            System.out.println(cli);
        }

        System.out.println("Eliminando cliente 1");
        clienteImp.eliminar(4098863L);

        System.out.println("Listado de clientes actualizada");
        for(Cliente cli : clienteImp.listar()){
            System.out.println(cli);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar: ");
        Long dni = sc.nextLong();

        Optional<Cliente> encontrado = clienteImp.buscar(dni);

        if (encontrado.isPresent()){
            System.out.println(encontrado);
        }
        else {
            System.out.println("No se encontró a la persona");
        }

        //PARTE 2

        //Creacion de facturas
        Facturas factura1 = new Facturas(cliente1,1);
        Facturas factura2 = new Facturas(cliente4,2);

        facturaImp.save(factura1);

        //Validacion de cliente en collecion clientes
        //factura1
        System.out.println("Validación cliente1, factura1");
        if(existe(factura1,clienteImp.listar())){
            System.out.println("El cliente existe");
            agregar(factura1, facturaImp.listar());
        }
        else{
            System.out.println("El cliente no existía, agregando..");
            clienteImp.save(factura1.getCliente());
            System.out.println("Cliente agregado con éxito");
            agregar(factura1, facturaImp.listar());
        }

        //factura2
        System.out.println("Validación cliente4, factura2");
        if(existe(factura2,clienteImp.listar())){
            System.out.println("El cliente existe");
            agregar(factura2, facturaImp.listar());
        }
        else{
            System.out.println("El cliente no existía, agregando..");
            clienteImp.save(factura2.getCliente());
            System.out.println("Cliente agregado con exito");
            agregar(factura2, facturaImp.listar());
        }

        //Creacion de items
        Item item1 = new Item(1,"arroz", 1, 10);
        Item item2 = new Item(2,"leche", 1, 10);
        Item item3 = new Item(3,"pan", 1, 10);

        //Creacion de lista
        itemImple.save(item1);
        itemImple.save(item2);
        itemImple.save(item3);

        factura1.agregarItemsLista(itemImple.listar());

        //Total de facura
        factura1.calcularFactura();
        System.out.println("El valor de la factura es : " + factura1.getTotal());


    }

    public static boolean existe(Facturas f, List<Cliente> clientes){
        Cliente cli = clientes.stream()
                .filter(x -> x.getDni() == f.getCliente().getDni())
                .findFirst().orElse(null);
        if (cli != null)
            return true;
        return false;
    }

    public static void agregar(Facturas f, List<Facturas> lista){
        lista.add(f);
    }
}
