package Clases;
import Interfaces.*;

public class Ejecutivo implements IDeposito, ITransferencia{

    /*
  * Ejecutivos: Realizan Depósitos y Transferencias.
  */
    public Ejecutivo(){};

    @Override
    public void RealizarDeposito(){
        System.out.println("Se está realizando una deposito...");
        double rand = Math.random();
        if(rand<5){
            transaccionOk();
        }else{
            transaccionNoOk();
        }
    }

    @Override
    public void RealizarTransferencia(){
        System.out.println("Se está realizando una transferencia...");
        double rand = Math.random();
        if(rand<5){
            transaccionOk();
        }else{
            transaccionNoOk();
        }
    }

    @Override
    public void transaccionOk() {
        System.out.println("La transacción fue exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no fue exitosa");
    }
    
}