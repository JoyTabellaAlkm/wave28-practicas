import java.util.ArrayList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Agencia agenciadeTurismo = new Agencia();

        Cliente c1 = new Cliente(1, "Camila", "Lopez");
        System.out.println(c1);

        agenciadeTurismo.agregarCliente(c1);

        Reserva r1 = new Reserva(1, true, true, true,true, 1000);
        Reserva r2 = new Reserva(2, true, false, true,false, 500);
        Reserva r3 = new Reserva(3, true, false, true,false, 500);
        Reserva r4 = new Reserva(4, false, false, false,true, 250);
        Reserva r5 = new Reserva(5, true, false, false,true, 500);

//      Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
        ArrayList<Reserva> listaReservaCamila = new ArrayList<Reserva>();
        listaReservaCamila.add(r1);

        Localizador paquete1 = new Localizador(1, listaReservaCamila, c1);
        System.out.println(paquete1.toString());

        agenciadeTurismo.agregarLocalizador(paquete1);

//      Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior,
//      almacenar e imprimir el resultado.

        ArrayList<Reserva> listaReservaCamilaOpcion2 = new ArrayList<Reserva>();
        listaReservaCamilaOpcion2.add(r2);
        listaReservaCamilaOpcion2.add(r3);



//        Crear un localizador con una sola reserva para el mismo cliente.
//        Verificar que los descuentos fueron aplicados.

    }
}