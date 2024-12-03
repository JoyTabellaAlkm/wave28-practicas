package ejercicio3;

public class Gato extends Animal implements Carnivoros{

    public Gato() {
        super.sonido = "Miau";
    }

    public void emitirSonido() {
        super.emitirSonido(this);
    }

    @Override
    public void comer(){
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }
}
