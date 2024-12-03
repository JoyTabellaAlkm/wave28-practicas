package ej2;

public class Main {
    public static void main(String[] args) {
        Prototipo serie2 = new Serie2();
        for(int i=0; i<10; i++) {
            System.out.println(serie2.siguiente());
        }
        serie2.setValorInicial(1);
        for(int i=0; i<10; i++) {
            System.out.println(serie2.siguiente());
        }

        Prototipo serie3 = new Serie3();
        for(int i=0; i<10; i++) {
            System.out.println(serie3.siguiente());
        }

    }
}
