import java.util.ArrayList;

public class Localizador {
    private int id;
    private ArrayList<Reserva> reservas;
    Cliente cliente;

    public Localizador(int id, ArrayList<Reserva> reservas, Cliente cliente) {
        this.id = id;
        this.reservas = reservas;
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return cliente;
    }

    @Override
    public String toString(){
        return "ID: " + id + " - Cliente: " + cliente.toString();
    }



}
