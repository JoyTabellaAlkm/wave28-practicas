public class Main {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        vaca.emitirSonido();
        System.out.println(vaca.comerHierba());

        perro.emitirSonido();
        System.out.println(perro.comerCarne());

        gato.emitirSonido();
        System.out.println(gato.comerCarne());

        System.out.println(Main.comerAnimal(vaca));
        System.out.println(Main.comerAnimal(perro));
        System.out.println(Main.comerAnimal(gato));
    }

    public static String comerAnimal(Animal animal) {
        if (animal instanceof ICarnivoro) {
            return ((ICarnivoro) animal).comerCarne();
        } else {
            return ((IHerviboro) animal).comerHierba();
        }
    }
}