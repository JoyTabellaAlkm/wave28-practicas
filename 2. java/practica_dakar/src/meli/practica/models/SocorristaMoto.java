package practica_dakar.src.meli.practica.models;

public class SocorristaMoto implements ISocorrista{
    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo moto con patente " + vehiculo.getPatente());
    }
}