package ej3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gato g = new Gato();
        Perro p = new Perro();
        Vaca v = new Vaca();
        List<Animal> animales = List.of(g, p, v);

        System.out.println("Sonidos de los animales:");
        animales.forEach(Animal::emitirSonido);

        System.out.println("Comen los animales:");
        g.comerCarne();
        p.comerCarne();
        v.comerHierba();

        System.out.println("Comer con metodo:");
        comerAnimal(g);
        comerAnimal(v);
    }

    private static void comerAnimal(Animal a) {
        if (a instanceof ICarnivoro)
            ((ICarnivoro) a).comerCarne();
        else if (a instanceof IHerviboro)
            ((IHerviboro) a).comerHierba();
    }
}
