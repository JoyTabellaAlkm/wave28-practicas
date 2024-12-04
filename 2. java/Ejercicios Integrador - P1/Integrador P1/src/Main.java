import almacenamiento.Localizador;
import almacenamiento.Repositorio;
import cliente.Cliente;
import reservas.*;

public class Main {
    public static void main(String[] args){
        Repositorio repo = new Repositorio();

        //Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
        Cliente cliente1 = new Cliente("12345", "Nico", "nico@correo.com");
        Localizador l1 = new Localizador(cliente1);

        l1.agregarReserva(new ReservaBoletos(300));
        l1.agregarReserva(new ReservaHotel(2000));
        l1.agregarReserva(new ReservaComida(60));
        l1.agregarReserva(new ReservaTransporte(20));

        repo.agregarLocalizador(cliente1, l1);

        //Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
        Localizador l2 = new Localizador(cliente1);

        l2.agregarReserva(new ReservaHotel(1500));
        l2.agregarReserva(new ReservaHotel(1700));
        l2.agregarReserva(new ReservaBoletos(120));
        l2.agregarReserva(new ReservaBoletos(175));

        repo.agregarLocalizador(cliente1, l2);

        //Crear un localizador con una sola reserva para el mismo cliente.
        Localizador l3 = new Localizador(cliente1);
        l3.agregarReserva(new ReservaComida(20));

        repo.agregarLocalizador(cliente1, l3);
        System.out.println(repo);
    }
}
