public class SocorristaAuto implements ISocorrista<Auto>{
    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto " + auto.getPatente() );
    }
}