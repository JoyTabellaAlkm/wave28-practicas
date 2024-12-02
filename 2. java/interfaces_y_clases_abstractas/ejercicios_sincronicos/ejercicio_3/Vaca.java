package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_3;

public class Vaca extends Animal implements Herviboro {
    public Vaca(String color, String especie, String nombre) {
        super(color, especie, nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierva...");
    }
}
