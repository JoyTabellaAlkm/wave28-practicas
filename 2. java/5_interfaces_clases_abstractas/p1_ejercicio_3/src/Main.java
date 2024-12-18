//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.sonido();
        perro.comerCarne();

        Gato gato = new Gato();
        gato.sonido();
        gato.comerCarne();

        Vaca vaca = new Vaca();
        vaca.sonido();
        vaca.comerHierba();


        // Adiccional

        comerAnimal(perro);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal){
        switch (animal) {
            case Perro perro -> perro.comerCarne();
            case Gato gato -> gato.comerCarne();
            case Vaca vaca -> vaca.comerHierba();
            case null, default -> throw new IllegalArgumentException("Tipo de animal no conocido");
        }
    }
}