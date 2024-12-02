package clasesAbstractas.ejGrupal1.ej3;

public class Vaca extends Animal implements IHerviboro{


    @Override
    public void emitirSonido() {
        System.out.println("muuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo pasto");
    }
}
