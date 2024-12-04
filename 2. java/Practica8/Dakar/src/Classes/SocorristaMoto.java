package Classes;

public class SocorristaMoto extends Moto{
    public SocorristaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo moto: " + unaMoto.getPatente());
    }
}
