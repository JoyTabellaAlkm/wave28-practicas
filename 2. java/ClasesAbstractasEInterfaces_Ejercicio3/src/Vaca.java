public class Vaca extends Animal implements IHerviboro{

    public Vaca(String nombre){
        super(nombre);
    }

    @Override
    public void emitirSonido(){
        System.out.println("Muuuu");
    }

    @Override
    public void comerHierba(){
        System.out.println(this.getNombre() + " come mucho pasto");

    };

}
