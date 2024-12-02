package com.example.Ejercicios_claseAbstractaEInterfaces.Ejercicio_Banco;

public interface ITransaccion {

    default String transaccionOk(){
        return "Transacción realizada correctamente";
    }
    default String transaccionNoOk(){
        return "Esta transacción no se puede efectuar";
    }

    public String depositar();
    public String tranferir();
    public String retirarEfectivo();
    public String cosnutlarSaldo();
    public String pagarServicio();

}
