package ejercicios.clasesAbstractasInterfaces.ejercicio1ClasesAbsInt;

public interface Transaccion {

    default void transaccionOk(){
        System.out.println("Transaccion exitosa");
    };
    default void transaccionNoOk(){
        System.out.println("Transaccion fallida");

    };

}
