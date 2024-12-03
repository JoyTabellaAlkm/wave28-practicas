package ejercicio3;

public class Vaca extends Animal implements Hervivoros{

    public Vaca() {
        super.sonido = "Muuu";
    }

    public void emitirSonido() {
        super.emitirSonido(this);
    }

    @Override
    public void comer(){
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierva");
    }
}
