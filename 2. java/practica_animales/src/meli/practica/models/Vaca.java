package practica_animales.src.meli.practica.models;

public class Vaca extends Animal implements ComerHierba{

    @Override
    public void emitirSonido(){
        System.out.println("Muuuu");
    }

    @Override
    public void comerHierba(){
        System.out.println("La vaca esta comiendo hierba");
    }

}
