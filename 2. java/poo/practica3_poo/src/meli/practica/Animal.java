package meli.practica;

public class Animal {
    
    private String especie;

    public String getEspecie(){
        return especie;
    }

    public void getEspecie(string especie){
        this.especie = especie;
    }

    public Animal(String especie) {
        this.especie = especie;
    }

    public void mostrarEspecie(){
        System.out.println("soy un animal de la especie: " + this.especie);
    }

    public void hacerSonido(){
        System.out.println("El animal hace un sonido: ");
    }
    
}
