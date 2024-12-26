abstract class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void emitirSonido();

    public static void comerAnimal(Animal animal) {
        if (animal instanceof ICarnivoro) {
            ((ICarnivoro) animal).comerCarne();
        } else if (animal instanceof IHerbivoro) {
            ((IHerbivoro) animal).comerHierba();
        } else {
            System.out.println(animal.getNombre() + " no tiene preferencias alimenticias definidas.");
        }
    }
}
