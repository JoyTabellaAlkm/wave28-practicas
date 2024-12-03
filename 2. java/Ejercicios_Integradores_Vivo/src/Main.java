import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(12345, "mirtha");
        Localizador localizador1 = new Localizador(cliente);
        Localizador localizador2 = new Localizador(cliente);
        Localizador localizador3 = new Localizador(cliente);
        cliente.agregarLocalizador(localizador1);
        cliente.agregarLocalizador(localizador2);
        cliente.agregarLocalizador(localizador3);

        localizador1.agregarReserva(new Reserva(1, ETipoReserva.BoletosViajes, cliente));
        localizador1.agregarReserva(new Reserva(2, ETipoReserva.BoletosViajes, cliente));
        localizador1.agregarReserva(new Reserva(3, ETipoReserva.Comida, cliente));
        localizador1.agregarReserva(new Reserva(2, ETipoReserva.Hotel, cliente));
        localizador1.agregarReserva(new Reserva(2, ETipoReserva.Hotel, cliente));
        localizador1.agregarReserva(new Reserva(2, ETipoReserva.Transporte, cliente));

        System.out.println("LOCALIZADOR1");
        System.out.println(STR."TOTAL SIN DESCUENTO \{localizador1.getMontoTotal()}");
        localizador1.aplicarDescuento();
        System.out.println(STR."TOTAL CON DESCUENTO \{localizador1.getTotalConDescuento()}");

        localizador2.agregarReserva(new Reserva(1, ETipoReserva.BoletosViajes, cliente));
        localizador2.agregarReserva(new Reserva(2, ETipoReserva.BoletosViajes, cliente));
        localizador2.agregarReserva(new Reserva(2, ETipoReserva.Hotel, cliente));
        localizador2.agregarReserva(new Reserva(2, ETipoReserva.Hotel, cliente));

        System.out.println("LOCALIZADOR2");
        System.out.println(STR."TOTAL SIN DESCUENTO \{localizador2.getMontoTotal()}");
        localizador2.aplicarDescuento();
        System.out.println(STR."TOTAL CON DESCUENTO \{localizador2.getTotalConDescuento()}");

        localizador3.agregarReserva(new Reserva(10, ETipoReserva.Comida, cliente));

        System.out.println("LOCALIZADOR3");
        System.out.println(STR."TOTAL SIN DESCUENTO \{localizador3.getMontoTotal()}");
        localizador3.aplicarDescuento();
        System.out.println(STR."TOTAL CON DESCUENTO \{localizador3.getTotalConDescuento()}");

        LocalizadorService localizadorService = new LocalizadorService(List.of(localizador1,localizador2,localizador3));
        System.out.println(localizadorService.cantidadLocalizadores());
        System.out.println(localizadorService.obtenerMapaReservasPorTipo());
        System.out.println(localizadorService.cantidadReservas());
    }
}
