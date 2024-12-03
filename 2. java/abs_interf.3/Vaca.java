public class Vaca extends Animal implements Herviboro{

    @Override
    void emitir_sonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }
    
}
