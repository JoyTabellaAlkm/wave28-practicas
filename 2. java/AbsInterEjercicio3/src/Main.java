import Clases.Animal;
import Clases.Gato;
import Clases.Perro;
import Clases.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.hacerRuido();
        perro.comerCarne();

        gato.hacerRuido();
        gato.comerCarne();

        vaca.hacerRuido();
        vaca.comerVerdura();

        Animal.comerAnimal(perro);
        Animal.comerAnimal(gato);
        Animal.comerAnimal(vaca);
    }
}