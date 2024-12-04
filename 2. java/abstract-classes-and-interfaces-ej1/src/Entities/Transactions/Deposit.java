package Entities.Transactions;

import Interfaces.ITransaction;

public class Deposit implements ITransaction {

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
        System.out.println("DEPOSITO EXITOSO");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("DEPOSITO FALLIDO");
    }
}
