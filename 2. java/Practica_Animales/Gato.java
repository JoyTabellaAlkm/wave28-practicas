public class Gato extends Animal implements Carnivoro{

    public static final String maulla = "miauuu";

    public Gato(String nombre){
        super(nombre);
    };

    @Override
    public void hacerSonido() {
        System.out.println(maulla);
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato " + getNombre() + " come carne");
    }  
}