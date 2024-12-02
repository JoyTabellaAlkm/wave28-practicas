package ejercicio3;

import ejercicio3.clases.Gato;
import ejercicio3.clases.Perro;
import ejercicio3.clases.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();

        gato.comerAnimal(vaca);
        perro.comerAnimal(vaca);
    }
}
