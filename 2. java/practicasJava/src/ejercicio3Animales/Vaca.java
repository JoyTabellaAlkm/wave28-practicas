package ejercicio3Animales;

public class Vaca extends Animal implements IHerviboro{

    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuuu");
    }

    @Override
    public void comerHierba(){
        System.out.println("Comio hierba");
    }
}
