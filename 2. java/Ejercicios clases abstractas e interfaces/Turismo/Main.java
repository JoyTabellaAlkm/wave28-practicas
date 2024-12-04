
public class Main {
    public static void main(String[] args) {
        //Creacion de cliente
        Cliente cliente = new Cliente(12345, "mirtha");

        //Localizadores
        Localizador localizador1 = new Localizador(cliente);
        Localizador localizador2 = new Localizador(cliente);
        Localizador localizador3 = new Localizador(cliente);

        //Agrego localizadores
        cliente.agregarLocalizador(localizador1);
        cliente.agregarLocalizador(localizador2);
        cliente.agregarLocalizador(localizador3);

        //Localizador 1
        localizador1.agregarReserva(new Reserva(1, ETipoReserva.BoletosViajes, cliente));
        localizador1.agregarReserva(new Reserva(3, ETipoReserva.Comida, cliente));
        localizador1.agregarReserva(new Reserva(2, ETipoReserva.Hotel, cliente));
        localizador1.agregarReserva(new Reserva(2, ETipoReserva.Transporte, cliente));

        System.out.println("LOCALIZADOR 1");
        System.out.println(STR."TOTAL SIN DESCUENTO \{localizador1.getMontoTotal()}");
        localizador1.aplicarDescuento();
        System.out.println(STR."TOTAL CON DESCUENTO \{localizador1.getTotalConDescuento()}");

        //Localizador 2
        localizador2.agregarReserva(new Reserva(1, ETipoReserva.BoletosViajes, cliente));
        localizador2.agregarReserva(new Reserva(2, ETipoReserva.BoletosViajes, cliente));
        localizador2.agregarReserva(new Reserva(2, ETipoReserva.Hotel, cliente));
        localizador2.agregarReserva(new Reserva(2, ETipoReserva.Hotel, cliente));

        System.out.println("LOCALIZADOR2");
        System.out.println(STR."TOTAL SIN DESCUENTO \{localizador2.getMontoTotal()}");
        localizador2.aplicarDescuento();
        System.out.println(STR."TOTAL CON DESCUENTO \{localizador2.getTotalConDescuento()}");

        //Localizador 3
        localizador3.agregarReserva(new Reserva(10, ETipoReserva.Comida, cliente));

        System.out.println("LOCALIZADOR3");
        System.out.println(STR."TOTAL SIN DESCUENTO \{localizador3.getMontoTotal()}");
        localizador3.aplicarDescuento();
        System.out.println(STR."TOTAL CON DESCUENTO \{localizador3.getTotalConDescuento()}");
    }
}