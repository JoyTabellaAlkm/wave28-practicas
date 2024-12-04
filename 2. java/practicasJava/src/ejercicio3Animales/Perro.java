package ejercicio3Animales;

public class Perro extends Animal implements ICarnivoro{

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido(){
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comio carne");
    }
}
