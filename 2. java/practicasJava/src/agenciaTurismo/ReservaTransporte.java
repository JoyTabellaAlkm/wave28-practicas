package agenciaTurismo;

public class ReservaTransporte extends Reserva{

    public ReservaTransporte(int id, String descripcion, Double precio) {
        super(id, descripcion,precio);
        this.setClases(3);

    }

    @Override
    public void crearReserva() {
        System.out.println("Se crea reserva de transporte.");
    }

    @Override
    public String toString() {
        return "ReservaTransporte{}";
    }
}
