import models.Animal;
import models.Gato;
import models.Perro;
import models.Vaca;

public class Main {
    public static void main(String[] args) {

        Animal vaca = new Vaca();
        Animal perro = new Perro();
        Animal gato = new Gato();

        vaca.emitirSonido();
        System.out.println(vaca.getGustoAlimenticio());

        perro.emitirSonido();
        System.out.println(perro.getGustoAlimenticio());

        gato.emitirSonido();
        System.out.println(gato.getGustoAlimenticio());
    }
}