package practica_animales.src.meli.practica.models;

public class Perro extends Animal implements ComerCarne {

    @Override
    public void emitirSonido(){
        System.out.println("Guau");
    }

    @Override
    public void comerCarne(){
        System.out.println("El perro esta comiendo carne");
    }

}
