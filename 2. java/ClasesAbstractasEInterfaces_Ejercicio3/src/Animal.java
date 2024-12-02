public abstract class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public abstract void emitirSonido();

    public void dormir() {
        System.out.println(this.nombre + " esta durmiendo.");
    }

    public void comerAnimal(Perro perro) {
        perro.comerCarne();
    }

    public void comerAnimal(Gato gato) {
        gato.comerCarne();
    }

    public void comerAnimal(Vaca vaca) {
        vaca.comerHierba();
    }

}
