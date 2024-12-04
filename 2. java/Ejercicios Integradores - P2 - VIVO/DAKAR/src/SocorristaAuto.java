public class SocorristaAuto implements ISocorrista{
    @Override
    public void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo auto con patente " + vehiculo.getPatente());
    }
}
