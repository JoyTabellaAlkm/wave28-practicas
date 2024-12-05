package dakar.model;

public class SocorristaMoto implements  ISocorristaMoto{

    @Override
    public void socorrer(Moto unaMoto) {
        System.out.println("Socorriendo moto: " + unaMoto.getPatente());
    }
}
