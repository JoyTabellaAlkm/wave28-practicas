package ejercicio3;

public abstract class Animal {
    String sonido;
    public void emitirSonido(Animal animal){
        System.out.println("El "+animal.getClass().getSimpleName()+ " hace "+ sonido);
    }

    static void comerAnimal(Animal animal){
        animal.comer();
    }

    public void comer(){};
}
