package practica_animales.src.meli.practica;

import practica_animales.src.meli.practica.models.Gato;
import practica_animales.src.meli.practica.models.Perro;
import practica_animales.src.meli.practica.models.Vaca;

public class Main {

    public static void main(String[] args) {

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        System.out.println(("--------------------"));

        // Acciones del perro

        perro.emitirSonido();
        perro.comerCarne();

        System.out.println(("--------------------"));

        // Acciones del gato

        gato.emitirSonido();
        gato.comerCarne();

        System.out.println(("--------------------"));

        // Acciones de la vaca

        vaca.emitirSonido();
        vaca.comerHierba();

        System.out.println(("--------------------"));




    }
    
}
