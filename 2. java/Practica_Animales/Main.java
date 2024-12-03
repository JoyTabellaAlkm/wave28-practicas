public class Main {
    public static void main(String[] args) {
        Gato g =  new Gato("michi");
        Perro p = new Perro("firulais");
        Vaca v = new Vaca("lola");

        g.comerCarne();
        g.hacerSonido();

        p.comerCarne();
        p.hacerSonido();

        v.comerHierba();
        v.hacerSonido();
    }
}