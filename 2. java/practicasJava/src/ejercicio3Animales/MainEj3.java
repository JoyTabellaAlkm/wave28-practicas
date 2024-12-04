package ejercicio3Animales;

public class MainEj3 {
    public static void main(String[] args){
        Perro perro = new Perro("Pedrito");
        Gato gato = new Gato("Firu");
        Vaca vaca = new Vaca("Lola");

        perro.emitirSonido();
        perro.comerCarne();
        gato.emitirSonido();
        gato.comerCarne();
        vaca.emitirSonido();
        vaca.comerHierba();

        comerAnimal(perro);
        comerAnimal(vaca);



    }
    private static void comerAnimal(Animal a) {
        if (a instanceof ICarnivoro)
            ((ICarnivoro) a).comerCarne();
        else if (a instanceof IHerviboro)
            ((IHerviboro) a).comerHierba();
    }
}
