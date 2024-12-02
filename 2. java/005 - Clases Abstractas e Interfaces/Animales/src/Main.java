import Modelo.Gato;
import Modelo.Perro;
import Modelo.Vaca;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();
        System.out.println("Gato");
        gato.emitirSonido();
        gato.comer();
        System.out.println("Perro");
        perro.emitirSonido();
        perro.comer();
        System.out.println("Vaca");
        vaca.emitirSonido();
        vaca.comer();
    }
}
