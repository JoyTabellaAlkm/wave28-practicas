public class Vaca extends Animal implements Hervivoro{

    public static final String muje = "muuuu";

    public Vaca(String nombre){
        super(nombre);
    };

    @Override
    public void hacerSonido() {
        System.out.println(muje);
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca " + getNombre() + " come carne");
        
    }  
}