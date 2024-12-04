package Interfaces;

public interface ITransaction {
    public void attemptTransaction(boolean isSuccesful);
    public void transactionOk();
    public void transactionNotOk();
}
