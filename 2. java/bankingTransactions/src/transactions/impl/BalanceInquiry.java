package transactions.impl;

import transactions.ITransaction;

public class BalanceInquiry implements ITransaction {

    @Override
    public void transactionOk() {
        System.out.println("Consulta de saldo realizada exitósamente");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("Error, no se puede realizar la consulta de saldo");
    }
}
