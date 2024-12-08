package models;

public abstract class Animal {

    protected String gustoAlimenticio;

    public String getGustoAlimenticio() {
        return gustoAlimenticio;
    }

    public void setGustoAlimenticio(String gustoAlimenticio) {
        this.gustoAlimenticio = gustoAlimenticio;
    }

    public abstract void emitirSonido();
}
