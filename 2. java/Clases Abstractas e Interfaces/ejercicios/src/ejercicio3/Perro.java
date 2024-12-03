package ejercicio3;

public class Perro extends Animal implements Carnivoros{

    public Perro() {
        super.sonido = "Guau";
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
        System.out.println("El perro come carne");
    }
}
