package ejercicio3.clases;

public abstract class Animal {
    private String especie;

    public abstract void emitirSonido();

    public Animal(String especie) {
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
