public class Perro extends Animal implements ICarnivoro{
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " dice: guauuu");
    }

    @Override
    public void comerCarne() {
        System.out.println(getNombre() + " esta comiendo carne.");
    }
}
