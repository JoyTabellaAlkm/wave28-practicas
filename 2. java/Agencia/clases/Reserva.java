package clases;

public class Reserva {
    private double price;
    private boolean haveHotel;
    private boolean haveBoletos;
    private boolean haveComida;
    private boolean haveTransporte;


    public Reserva(double price, boolean have_hotel, boolean have_comida, boolean have_boletos, boolean have_transporte){
        this.price = price;
        this.haveHotel= have_hotel;
        this.haveBoletos = have_boletos;
        this.haveComida = have_comida;
        this.haveTransporte = have_transporte;
    }

    public double getPrice() {
        return price;
    }

    public boolean getHaveHotel() {
        return haveHotel;
    }

    public boolean gethaveComida() {
        return haveComida;
    }

    public boolean getHaveBoletos() {
        return haveBoletos;
    }

    public boolean getHaveTransporte() {
        return haveTransporte;
    }

    @Override
    public String toString() {
        return "Price: " + this.price +
                ", hotel: " + this.haveHotel +
                ", boletos: " + this.haveBoletos +
                ", Comida: " + this.haveComida +
                ", Transporte: " + haveTransporte;
    }
}
