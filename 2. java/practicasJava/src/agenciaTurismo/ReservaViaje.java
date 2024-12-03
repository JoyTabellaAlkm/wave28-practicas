package agenciaTurismo;

public class ReservaViaje extends Reserva{


    public ReservaViaje(int id, String descripcion,Double precio) {
        super(id, descripcion,precio);
        this.setClases(4);
    }

    @Override
    public void crearReserva() {
        System.out.println("Se crea reserva de viaje.");
    }

    @Override
    public String toString() {
        return "ReservaViaje{}";
    }
}
