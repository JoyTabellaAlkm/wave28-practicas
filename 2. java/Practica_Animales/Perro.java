public class Perro extends Animal implements Carnivoro{

    public static final String ladra = "guauuu";

    public Perro(String nombre){
        super(nombre);
    };

    @Override
    public void hacerSonido() {
        System.out.println(ladra);
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro " + getNombre() + " come carne");
        
    }  
}