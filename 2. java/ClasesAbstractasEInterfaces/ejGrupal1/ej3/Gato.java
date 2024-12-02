package clasesAbstractas.ejGrupal1.ej3;

import java.sql.SQLOutput;

public class Gato extends Animal implements ICarnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("miaaauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer atun");
    }
}
