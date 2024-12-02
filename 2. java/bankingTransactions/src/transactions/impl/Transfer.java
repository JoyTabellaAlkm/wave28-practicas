package transactions.impl;

import transactions.ITransaction;

public class Transfer implements ITransaction {
    @Override
    public void transactionOk() {
        System.out.println("Transferencia realizada exitósamente");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Error, no se puede realizar la transferencia");
    }
}
