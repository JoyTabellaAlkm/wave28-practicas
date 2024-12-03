public class ReservaHotel extends Reserva{
    private String nombreHotel;

    public ReservaHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public ReservaHotel(String detalle, Double costo, String nombreHotel) {
        super(detalle, costo);
        this.nombreHotel = nombreHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ReservaHotel{" +
                "nombreHotel='" + nombreHotel + '\'' +
                '}';
    }
}