package ejercicio3Animales;

public abstract class Animal {
    private String nombre;

    public abstract void emitirSonido();

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
