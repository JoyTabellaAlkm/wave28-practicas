public class Reserva {
    private int id ;
    private boolean hotel;
    private boolean comida;
    private boolean viaje;
    private boolean transporte;
    private double precio;

    public Reserva(int id, boolean hotel, boolean comida, boolean viaje, boolean transporte, int precio) {
        this.id = id;
        this.comida = comida;
        this.viaje = viaje;
        this.transporte = transporte;
        this.hotel = hotel;
        this.precio = precio;
    }


    @Override
    public String toString(){
        return "ID: " + id + " Hotel: " + this.hotel + ", comida: " + this.comida + ", viaje: " + this.viaje + ", transporte: " + this.transporte;
    }
}
