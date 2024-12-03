public class Perro extends Animal implements Carnivoro {

    @Override
    void emitir_sonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");

    }
    
}
