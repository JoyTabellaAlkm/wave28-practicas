package practica_animales.src.meli.practica.models;

public class Gato extends Animal implements ComerCarne{

    @Override
    public void emitirSonido(){
        System.out.println("Miau");
    }

    @Override
    public void comerCarne(){
        System.out.println("El Gato esta comiendo carne");
    }

}
