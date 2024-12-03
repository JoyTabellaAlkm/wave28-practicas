public class Vaca extends Animal implements IHerviboro{
    public Vaca() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public String comerHierba() {
        return "Vaca comiendo hierba...";
    }
}
