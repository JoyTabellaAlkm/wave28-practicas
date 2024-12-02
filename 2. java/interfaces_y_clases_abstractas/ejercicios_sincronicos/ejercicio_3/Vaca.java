package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_3;

public class Vaca extends Animal {
    public Vaca(String color, String especie, String nombre) {
        super(color, especie, nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuuu");
    }
}
