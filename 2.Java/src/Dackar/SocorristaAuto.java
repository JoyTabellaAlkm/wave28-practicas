package Dackar;

public class SocorristaAuto implements ISocorrista{

    @Override
    public void socorrer(Vehiculo vehiculo) {

        System.out.println("Socorriendo auto " + vehiculo.getPatente() );
    }

    @Override
    public void socorrer(Auto auto) {

    }
}
