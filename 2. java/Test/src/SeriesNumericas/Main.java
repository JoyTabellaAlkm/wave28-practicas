package SeriesNumericas;

public class Main {
    public static void main(String[] args) {
        Prototipo prototipo = new Serie2();
        System.out.println("------------- SERIE 2 -------------");
        for (int i=0; i<10; i++) {
            System.out.println(prototipo.siguiente());
        }
        System.out.println("------------- SERIE 2 VALOR INICIAL-------------");
        prototipo.setValorInicial(1);
        for (int i=0; i<10; i++) {
            System.out.println(prototipo.siguiente());
        }
        System.out.println("------------- SERIE 3 -------------");
        Prototipo prototipo2 = new Serie3();
        for (int i=0; i<10; i++) {
            System.out.println(prototipo2.siguiente());
        }




    }
}
