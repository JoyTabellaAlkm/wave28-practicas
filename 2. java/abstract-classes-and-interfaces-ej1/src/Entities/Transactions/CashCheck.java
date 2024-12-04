package Entities.Transactions;

import Interfaces.ITransaction;

public class CashCheck implements ITransaction {


    @Override
    public void attemptTransaction(boolean isSuccesful) {

    }

    @Override
    public void transactionOk() {
        System.out.println("REVISION DE FONDOS EXITOSA");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("REVISION DE FONDOS FALLIDA");
    }
}
