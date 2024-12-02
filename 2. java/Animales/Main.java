public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        System.out.println("Gato");
        System.out.println(gato.hacerSonido());
        System.out.println(gato.comerCarne());
        System.out.println();

        System.out.println("Vaca");
        System.out.println(vaca.hacerSonido());
        System.out.println(vaca.comerHierba());
        System.out.println();

        System.out.println("Perro");
        System.out.println(perro.hacerSonido());
        System.out.println(perro.comerCarne());
    }
}