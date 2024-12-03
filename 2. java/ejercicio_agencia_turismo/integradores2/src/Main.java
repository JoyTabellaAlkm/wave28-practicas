import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RepositorioClientes repositorioClientes = new RepositorioClientes();

        Cliente cliente1 = new Cliente("Pepito", 123456);

        Reserva reservaPepito = new Reserva(123, "transporte", 200);
        Reserva reservaPepito2 = new Reserva(124, "hotel", 500);
        Reserva reservaPepito3 = new Reserva(125, "comida", 700);
        Reserva reservaPepito4 = new Reserva(126, "boletos", 300);

        Localizador localizadorPepito = new Localizador(123456, cliente1, 1700,
                List.of(reservaPepito, reservaPepito2, reservaPepito3, reservaPepito4));

        cliente1.agregarLocalizador(localizadorPepito);

        repositorioClientes.guardarCliente(cliente1);

        //1. localizador almacenar e imprimir
        System.out.println("=========Item1==========");
        localizadorPepito.imprimirLocalizador();

        //2. Agregar completo
        Reserva reservaPepito11 = new Reserva(123, "hotel", 200);
        Reserva reservaPepito22 = new Reserva(124, "hotel", 500);
        Reserva reservaPepito23 = new Reserva(125, "boletos", 300);
        Reserva reservaPepito24 = new Reserva(126, "boletos", 300);

        Localizador localizadorPepito2 = new Localizador(456, cliente1, 1300,
                List.of(reservaPepito11,reservaPepito22,reservaPepito23,reservaPepito24));

        cliente1.agregarLocalizador(localizadorPepito2);

        System.out.println("=========Item2==========");
        for (Localizador localizador: cliente1.getLocalizadores()){
            localizador.imprimirLocalizador();
            System.out.println("==================================");
        }

        //3. Agregar una sola reserva

        Reserva reservaPepito111 = new Reserva(789, "hotel", 200);
        Localizador localizadorPepito3 = new Localizador(789, cliente1, 200,
                List.of(reservaPepito111));
        cliente1.agregarLocalizador(localizadorPepito3);

        // Calcular descuento
        System.out.println("El total con descuentos es: " + repositorioClientes.aplicarDescuento(cliente1));

        // Total localizadores
        System.out.println("El total de localizadores es: " + repositorioClientes.totalLocalizadores());

        // Total reservas
        System.out.println("El total de reservas es: " + repositorioClientes.totalReservas());

        //Mapa reservas
        System.out.println(repositorioClientes.diccionarioReservas());

        //Total de ventas
        System.out.println(String.format("Total ventas = %f", repositorioClientes.calcularVentas()));
        // Promedio de ventas
        System.out.println(String.format("Promedio ventas = %f", repositorioClientes.calcularPromedioVentas()));
    }
}