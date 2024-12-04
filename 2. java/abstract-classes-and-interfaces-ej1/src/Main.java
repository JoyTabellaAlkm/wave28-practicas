import Entities.Basic;
import Entities.DebtCollector;
import Entities.Executive;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        DebtCollector debtCollector = new DebtCollector();
        Executive executive = new Executive();

        basic.tryCashWithdrawal();
        basic.tryDeposit();
        basic.tryServicePay();
        System.out.println("#############################");
        debtCollector.tryCashCheck();
        debtCollector.tryCashWithdrawal();
        System.out.println("#############################");
        executive.tryTransfer();
        executive.tryDeposit();
    }
}
