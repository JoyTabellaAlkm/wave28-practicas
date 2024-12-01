package Herencia;

public class POOMain {
      public static void main(String[] args) {
        Animal perro= new Perro("Perro", "tito");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Animal gato= new Gato("Gato", "michi");
        gato.mostrarEspecie();
        gato.hacerSonido();

    }
}
