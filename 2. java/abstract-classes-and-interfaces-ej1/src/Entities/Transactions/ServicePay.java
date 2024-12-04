package Entities.Transactions;

import Interfaces.ITransaction;

public class ServicePay implements ITransaction {

    @Override
    public void attemptTransaction(boolean isSuccesful) {
        if(isSuccesful){
            transactionOk();
        } else{
            transactionNotOk();
        }
    }

    @Override
    public void transactionOk() {
        System.out.println("PAGO DE SERVICIOS EXITOSO");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("PAGO DE SERVICIOS FALLIDO");
    }
}
