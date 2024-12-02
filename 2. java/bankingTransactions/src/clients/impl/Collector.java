package clients.impl;

import clients.IClient;
import transactions.ITransaction;
import transactions.impl.BalanceInquiry;
import transactions.impl.WithdrawalOfCash;

public class Collector implements IClient {
    @Override
    public void makeTransaction(ITransaction transaction) {
        if (transaction instanceof WithdrawalOfCash || transaction instanceof BalanceInquiry) {
            transaction.transactionOk();
        } else {
            transaction.transactionNotOk();
        }
    }
}
