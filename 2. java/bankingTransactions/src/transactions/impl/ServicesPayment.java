package transactions.impl;

import transactions.ITransaction;

public class ServicesPayment implements ITransaction {
    @Override
    public void transactionOk() {
        System.out.println("Pago de servicios realizado exitósamente");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Error, no se puede realizar el pago de servicios");
    }
}
