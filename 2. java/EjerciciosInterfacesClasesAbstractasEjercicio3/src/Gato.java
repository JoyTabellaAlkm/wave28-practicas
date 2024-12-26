public class Gato extends Animal implements ICarnivoro{
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " dice: Miauuu");
    }

    @Override
    public void comerCarne() {
        System.out.println(getNombre() + " esta comiendo carne.");
    }
}
