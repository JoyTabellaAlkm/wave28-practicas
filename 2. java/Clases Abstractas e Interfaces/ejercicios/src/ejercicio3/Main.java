package ejercicio3;

public class Main {

    public static void main(String[] args){
        Perro perro = new Perro();
        perro.emitirSonido();
        Animal.comerAnimal(perro);

        Gato gato = new Gato();
        gato.emitirSonido();
        Animal.comerAnimal(gato);

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        Animal.comerAnimal(vaca);
    }
}
