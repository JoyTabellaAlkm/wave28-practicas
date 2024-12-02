package ejercicios.ejercicio3ClasesAbsInt;

public class Perro extends Animal implements Comida{
    @Override
    public String emitirSonido() {
        return "Guau";
    }

    @Override
    public String comer() {
        return this.comerCarne();
    }
}
