public class Main {
    public static void main(String[] args) {

        Animal perro = new Perro("Lola");
        Animal gato = new Gato("Felix");
        Animal vaca = new Vaca("Fernandino");

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        Animal.comerAnimal(perro);
        Animal.comerAnimal(gato);
        Animal.comerAnimal(vaca);

    }
}