package transactions.impl;

import transactions.ITransaction;

public class WithdrawalOfCash implements ITransaction {
    @Override
    public void transactionOk() {
        System.out.println("Retiro de dinero realizado exitósamente");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Error, no se puede realizar el retiro de dinero");
    }
}
