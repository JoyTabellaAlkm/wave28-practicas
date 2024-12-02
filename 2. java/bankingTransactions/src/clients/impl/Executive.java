package clients.impl;

import clients.IClient;
import transactions.ITransaction;
import transactions.impl.Deposit;
import transactions.impl.Transfer;

public class Executive implements IClient {
    @Override
    public void makeTransaction(ITransaction transaction) {
        if (transaction instanceof Deposit || transaction instanceof Transfer) {
            transaction.transactionOk();
        } else {
            transaction.transactionNotOk();
        }
    }
}
