package Herencia;

public class Animal {
    private String especie;

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Animal(String especie){this.especie = especie;}
    public void mostrarEspecie(){System.out.println("Soy un animal de la especie: " + this.especie);}

    public void hacerSonido(){System.out.print("El animal hace el sonido");}





}