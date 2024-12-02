package transactions.impl;

import transactions.ITransaction;

public class Deposit implements ITransaction {
    @Override
    public void transactionOk() {
        System.out.println("Deposito realizado exitósamente");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Error, no se puede realizar el deposito");
    }
}
