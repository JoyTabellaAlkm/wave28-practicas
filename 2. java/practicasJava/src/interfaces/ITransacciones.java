package interfaces;

import java.sql.SQLOutput;

public interface ITransacciones {

    public default void transaccionOK(){
        System.out.println("Transacción OK.");

    }

    public default void transaccionNoOk(){
        System.out.println("Transaccion No OK.");
    }

}
