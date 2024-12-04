package ejercicio3Animales;

public class Gato extends Animal implements ICarnivoro{

    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido(){
        System.out.println("miau");
    }
    @Override
    public void comerCarne() {
        System.out.println("Comio carne");
    }
}
