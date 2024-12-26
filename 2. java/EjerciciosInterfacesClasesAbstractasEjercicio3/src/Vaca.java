public class Vaca extends Animal implements IHerbivoro{
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " dice: Muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println(getNombre() + " esta comiendo hierba");
    }
}
