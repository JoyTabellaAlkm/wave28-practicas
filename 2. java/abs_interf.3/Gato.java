public class Gato extends Animal implements Carnivoro{

    @Override
    void emitir_sonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
    
}
