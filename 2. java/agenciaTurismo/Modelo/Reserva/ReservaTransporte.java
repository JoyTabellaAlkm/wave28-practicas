public class ReservaTransporte extends Reserva{
    private String medioTransporte;

    public ReservaTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public ReservaTransporte(String detalle, Double costo, String medioTransporte) {
        super(detalle, costo);
        this.medioTransporte = medioTransporte;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ReservaTransporte{" +
                "medioTransporte='" + medioTransporte + '\'' +
                '}';
    }
}