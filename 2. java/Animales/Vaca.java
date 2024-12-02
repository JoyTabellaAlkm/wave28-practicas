public class Vaca extends Animal implements IHerviboro{

    public Vaca() {
    }

    @Override
    public String hacerSonido() {
        return "muuu";
    }

    @Override
    public String comerHierba() {
        return "La vaca esta comiendo Hierba";
    }
}
