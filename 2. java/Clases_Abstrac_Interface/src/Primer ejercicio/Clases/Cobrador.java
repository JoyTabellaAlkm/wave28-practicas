package Clases;
import Interfaces.*;

public class Cobrador implements IRetiroDeEfectivo, IConsultaDeSaldo{
/*
Cobradores: Realizan retiro de efectivo y consulta de saldos.
  */

    public Cobrador(){};
    
    @Override
    public void RealizarRetiro(){
        System.out.println("Se está realizando una retiro de efectivo...");
        double rand = Math.random();
        if(rand<5){
            transaccionOk();
        }else{
            transaccionNoOk();
        }
    }

    @Override
    public void RealizarConsulta(){
        System.out.println("Se está realizando una consulta de saldo...");
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