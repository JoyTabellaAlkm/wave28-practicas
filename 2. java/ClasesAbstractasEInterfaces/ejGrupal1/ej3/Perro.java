package clasesAbstractas.ejGrupal1.ej3;

public class Perro extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("guauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer hueso");
    }
}
