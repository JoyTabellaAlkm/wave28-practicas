package meli.practica;

public class POOMain {

    public static void main(String[] args){
        Animal perro = new Perro("perro","Tito");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Gato gato = new Gato("gato", "poker");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal = perro;
        animal.mostrarEspecie();
        animal.hacerSonido();
    }
}
