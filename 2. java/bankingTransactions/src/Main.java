import clients.IClient;
import clients.impl.Basic;
import clients.impl.Collector;
import clients.impl.Executive;
import transactions.ITransaction;
import transactions.impl.*;

public class Main {
    public static void main(String[] args) {
        //Transactions
        ITransaction deposit = new Deposit();
        ITransaction transfer = new Transfer();
        ITransaction withdrawalOfCash = new WithdrawalOfCash();
        ITransaction balanceInquiry = new BalanceInquiry();
        ITransaction servicesPayment = new ServicesPayment();

        //Clients
        IClient executiveClient = new Executive();
        IClient basicClient = new Basic();
        IClient collectorClient = new Collector();

        //Operations
        executiveClient.makeTransaction(deposit); //Ok
        executiveClient.makeTransaction(servicesPayment);//Not allowed

        basicClient.makeTransaction(balanceInquiry);//Ok
        basicClient.makeTransaction(transfer);//Not allowed

        collectorClient.makeTransaction(withdrawalOfCash);//Ok
        collectorClient.makeTransaction(transfer);
    }
}