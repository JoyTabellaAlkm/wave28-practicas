package Entities;

import Entities.Transactions.CashCheck;
import Entities.Transactions.CashWithdrawal;
import Entities.Transactions.Deposit;
import Entities.Transactions.Transfer;
import Interfaces.ITransaction;

import java.util.ArrayList;
import java.util.List;

public class DebtCollector extends Client{
    public DebtCollector(){
        super();
        List<ITransaction> toAssign = new ArrayList<>();
        toAssign.add(new CashCheck());
        toAssign.add(new CashWithdrawal());
        setAvailableActions(toAssign);
    }

    public void tryCashCheck(){
        for (ITransaction transaction : getAvailableActions())
        {
            if (transaction instanceof CashCheck){
                transaction.attemptTransaction(true);
                transaction.attemptTransaction(false);
            }
        }
    }

    public void tryCashWithdrawal(){
        for (ITransaction transaction : getAvailableActions())
        {
            if (transaction instanceof CashWithdrawal){
                transaction.attemptTransaction(true);
                transaction.attemptTransaction(false);
            }
        }
    }
}
