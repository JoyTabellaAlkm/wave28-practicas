package agenciaTurismo;

public class ReservaComida  extends Reserva{

    public ReservaComida(int id, String descripcion, Double precio) {
        super(id, descripcion,precio);
        this.setClases(1);
    }



    @Override
    public void crearReserva() {
        System.out.println("Se crea reserva de comida");
    }

    @Override
    public String toString() {
        return "ReservaComida{}";
    }
}
