package agenciaTurismo;

public class ReservaHotel extends Reserva{

    public ReservaHotel(int id, String descripcion,Double precio) {
        super(id, descripcion,precio);
        this.setClases(2);
    }

    @Override
    public void crearReserva() {
        System.out.println("Se crea reserva del hotel.");

    }

    @Override
    public String toString() {
        return "ReservaHotel{}";
    }
}
