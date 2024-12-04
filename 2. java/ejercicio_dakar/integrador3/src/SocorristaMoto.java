public class SocorristaMoto implements ISocorrista<Moto>{
    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto " + moto.getPatente() );
    }
}