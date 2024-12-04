package Entities;

import Entities.Transactions.Deposit;
import Entities.Transactions.Transfer;
import Interfaces.ITransaction;

import java.util.ArrayList;
import java.util.List;

public class Executive extends Client{

    public Executive(){
        super();
        List<ITransaction> toAssign = new ArrayList<>();
        toAssign.add(new Deposit());
        toAssign.add(new Transfer());
        setAvailableActions(toAssign);
    }

    public void tryDeposit(){
        for (ITransaction transaction : getAvailableActions())
        {
            if (transaction instanceof Deposit){
                transaction.attemptTransaction(true);
                transaction.attemptTransaction(false);
            }
        }
    }

    public void tryTransfer(){
        for (ITransaction transaction : getAvailableActions())
        {
            if (transaction instanceof Transfer){
                transaction.attemptTransaction(true);
                transaction.attemptTransaction(false);
            }
        }
    }
}
