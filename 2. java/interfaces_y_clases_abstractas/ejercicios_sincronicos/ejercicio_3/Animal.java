package interfaces_y_clases_abstractas.ejercicios_sincronicos.ejercicio_3;

public abstract class Animal {
    private String nombre;
    private String color;

    public Animal(String color, String especie, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void emitirSonido();

    public void comer(Animal animal) {
        System.out.println(this.nombre + " se ha comido a " + animal.getNombre());
    }

    @Override
    public String toString() {
        return "Animal{" +
                "color='" + color + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
