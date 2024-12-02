package clients.impl;

import clients.IClient;
import transactions.ITransaction;
import transactions.impl.BalanceInquiry;
import transactions.impl.ServicesPayment;
import transactions.impl.WithdrawalOfCash;

public class Basic implements IClient {

    @Override
    public void makeTransaction(ITransaction transaction) {
        if (transaction instanceof WithdrawalOfCash || transaction instanceof ServicesPayment || transaction instanceof BalanceInquiry) {
            transaction.transactionOk();
        } else {
            transaction.transactionNotOk();
        }
    }
}
