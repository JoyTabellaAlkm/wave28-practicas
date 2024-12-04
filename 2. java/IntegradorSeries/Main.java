public class Main {
    public static void main(String[] args) {

        Prototipo s2 = new Serie2();
        Prototipo s3 = new Serie3();

        System.out.println("serie 2 empieza x 0");
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());

        s2.reiniciarValor();
        s2.valorInicial(3);

        System.out.println();
        System.out.println("serie 2 con valor inicial seteado en 3");
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());

        System.out.println();
        System.out.println("serie 3 empieza x 0");
        System.out.println(s3.valorSiguiente());
        System.out.println(s3.valorSiguiente());
        System.out.println(s3.valorSiguiente());

        s3.reiniciarValor();
        s3.valorInicial(7);

        System.out.println();
        System.out.println("serie 3 con valor inicial seteado en 7");
        System.out.println(s3.valorSiguiente());
        System.out.println(s3.valorSiguiente());
        System.out.println(s3.valorSiguiente());
    }
}