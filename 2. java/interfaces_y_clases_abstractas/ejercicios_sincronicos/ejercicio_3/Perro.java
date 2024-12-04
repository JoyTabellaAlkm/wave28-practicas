package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_3;

public class Perro extends Animal implements Carnivoro{
    public Perro(String color, String especie, String nombre) {
        super(color, especie, nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne, guau!");
    }
}