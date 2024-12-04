package Entities.Transactions;

import Interfaces.ITransaction;

public class Transfer implements ITransaction {

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
        System.out.println("TRANSFERENCIA EXITOSA");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("TRANSFERENCIA FALLIDA");
    }
}
