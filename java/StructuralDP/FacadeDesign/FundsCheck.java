package StructuralDP.FacadeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class FundsCheck {

    private double cashInAccount = 1000.00;

    public double getCashInAccount(){
        return cashInAccount;
    }

    public void increaseCashInAccount(double cashDeposited){
        cashInAccount +=cashDeposited;
    }


    public void decreaseCashInAccount(double cashWithdrawn){
        cashInAccount -=cashWithdrawn;
    }

    public boolean haveEnoughMoney(double cashToWithdaw){
        if(cashToWithdaw > getCashInAccount()) {
            System.out.println("ERROR: You do not have enough money in your account");
            System.out.println("Current Balance: "+ getCashInAccount());
            return false;
        }
        else{
            decreaseCashInAccount(cashToWithdaw);
            System.out.println("Withdraw of "+cashToWithdaw+" Complete ! ");
            System.out.println("Current Balance: "+ getCashInAccount());
            return true;
        }

    }

    public void makeDeposit(double cashToDeposit){
        increaseCashInAccount(cashToDeposit);
        System.out.println("Deposit of "+cashToDeposit+" Complete ! ");
        System.out.println("Current Balance: "+ getCashInAccount());
    }
}
