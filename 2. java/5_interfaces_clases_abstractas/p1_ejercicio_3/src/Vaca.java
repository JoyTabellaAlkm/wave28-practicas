public class Vaca extends Animal implements IHervivoro {
    @Override
    public void sonido() {
        System.out.println("Muuu, Muuu, Muuu...");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba");
    }
}
