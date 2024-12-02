package ejercicios.ejercicio3ClasesAbsInt;

public class Gato extends Animal implements Comida{
    @Override
    public String emitirSonido() {
        return "Miau";
    }

    public String comer() {
        return this.comerCarne();
    }
}
