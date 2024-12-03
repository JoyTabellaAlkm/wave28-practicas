package ejercicios.integradores.clasesAbstractas;

public class Main {
    public static void main(String[] args){
        Serie2 serie2 = new Serie2();
        Serie1 serie1 = new Serie1();

        System.out.println("Pruebas serie 2");
        serie2.establecerInicio(0);
        System.out.println("establecer nuevo inicio" + serie2);
        for (int i=0; i<3; i++){
            serie2.siguiente();
            System.out.println("siguiente: ");
            System.out.println(serie2);
        }
        serie2.reinicio();
        System.out.println("restablecer" + serie2);

        System.out.println("Pruebas serie 1");
        serie1.establecerInicio(0);
        System.out.println("establecer nuevo inicio" + serie1);
        for (int i=0; i<3; i++){
            serie1.siguiente();
            System.out.println("siguiente: ");
            System.out.println(serie1);
        }
        serie1.reinicio();
        System.out.println("restablecer" + serie1);
    }
}
