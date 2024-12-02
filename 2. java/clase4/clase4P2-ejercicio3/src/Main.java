import Clases.Animal;
import Clases.Gato;
import Clases.Perro;
import Clases.Vaca;

public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca("Lola");
        Perro perro = new Perro("Firulais");
        Gato gato = new Gato("Akira");

        vaca.comerHierba();
        vaca.emitirSonid();

        perro.comerCarne();
        perro.emitirSonid();

        gato.comerCarne();
        gato.emitirSonid();
    }
}
