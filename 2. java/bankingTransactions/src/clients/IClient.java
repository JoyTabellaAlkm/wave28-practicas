package clients;

import transactions.ITransaction;

public interface IClient {
    void makeTransaction(ITransaction transaction);
}
