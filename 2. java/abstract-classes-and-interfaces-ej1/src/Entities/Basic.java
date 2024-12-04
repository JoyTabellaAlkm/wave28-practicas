package Entities;

import Entities.Transactions.CashWithdrawal;
import Entities.Transactions.Deposit;
import Entities.Transactions.ServicePay;
import Entities.Transactions.Transfer;
import Interfaces.ITransaction;

import java.util.ArrayList;
import java.util.List;

public class Basic extends Client{
    public Basic(){
        super();
        List<ITransaction> toAssign = new ArrayList<>();
        toAssign.add(new Deposit());
        toAssign.add(new ServicePay());
        toAssign.add(new CashWithdrawal());
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

    public void tryCashWithdrawal(){
        for (ITransaction transaction : getAvailableActions())
        {
            if (transaction instanceof CashWithdrawal){
                transaction.attemptTransaction(true);
                transaction.attemptTransaction(false);
            }
        }
    }

    public void tryServicePay(){
        for (ITransaction transaction : getAvailableActions())
        {
            if (transaction instanceof ServicePay){
                transaction.attemptTransaction(true);
                transaction.attemptTransaction(false);
            }
        }
    }


}
