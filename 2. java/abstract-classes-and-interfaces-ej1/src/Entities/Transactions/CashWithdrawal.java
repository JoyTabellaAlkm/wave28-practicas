package Entities.Transactions;

import Interfaces.ITransaction;

public class CashWithdrawal implements ITransaction {


    @Override
    public void attemptTransaction(boolean isSuccesful) {
        if(isSuccesful){
            transactionOk();
        } else{
            transactionNotOk();
        }
    }

    @Override
    public void transactionOk() {
        System.out.println("RETIRO DE FONDOS EXITOSO");
    }

    @Override
    public void transactionNotOk() {
        System.out.println("RETIRO DE FONDOS FALLIDO");
    }
}
