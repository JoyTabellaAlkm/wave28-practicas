package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_3;

public class Gato extends Animal implements Carnivoro{
    public Gato(String color, String especie, String nombre) {
        super(color, especie, nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne, miau");
    }
}
