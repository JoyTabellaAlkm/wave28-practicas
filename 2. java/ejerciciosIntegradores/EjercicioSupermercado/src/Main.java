import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ItemsCRUD items = new ItemsCRUD();
        productosPorDefecto(items);
        List<Items> allProducts = items.listar();

        ClientesCRUD clientesCRUD = new ClientesCRUD();
        clientesPorDefecto(clientesCRUD);

        Clientes comprador = new Clientes("Maria", "Perez", "23677612");

        Clientes isExistClient = clientesCRUD.leer(comprador);
        if(isExistClient == null){
            clientesCRUD.crear(comprador);
        }

        Factura factura = new Factura(isExistClient, allProducts, 1000);
        System.out.println(factura);

    }

    public static void clientesPorDefecto(ClientesCRUD clientesCRUD){
        Clientes c1 = new Clientes("Maria", "Perez", "23677612");
        Clientes c2 = new Clientes("Ana", "Torrez", "24677622");
        Clientes c3 = new Clientes("Auri", "Silva", "25677612");

        clientesCRUD.crear(c1);
        clientesCRUD.crear(c2);
        clientesCRUD.crear(c3);
    }

    public static void productosPorDefecto(ItemsCRUD items){
        Items i1 = new Items("Harina", 10.000);
        Items i2 = new Items("Arroz", 9.000);
        Items i3 = new Items("Leche", 2.000);

        items.crear(i1);
        items.crear(i2);
        items.crear(i3);
    }

}