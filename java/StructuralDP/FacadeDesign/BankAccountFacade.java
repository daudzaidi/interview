package StructuralDP.FacadeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class BankAccountFacade {

    private int accountNumber;
    private int securityCode;

    AccountNumberCheck accountChecker;
    SecurityCodeCheck  codeChecker;
    FundsCheck fundsChecker;

    WelcomeToBank welcomeToBank;

    public BankAccountFacade(int accountNUmber, int securityCode){
        this.accountNumber = accountNUmber;
        this.securityCode = securityCode;
        welcomeToBank = new WelcomeToBank();
        accountChecker = new AccountNumberCheck();
        codeChecker = new SecurityCodeCheck();
        fundsChecker = new FundsCheck();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void withdrawCash(double cashToGet){

        if(accountChecker.accountActive(getAccountNumber()) && codeChecker.isCodeCorrect(getSecurityCode())
                && fundsChecker.haveEnoughMoney(cashToGet)){

            System.out.println("TRANSACTION COMPLETED");
            System.out.println();
        }
        else{
            System.out.println("TRANSACTION FAILED");
            System.out.println();
        }
    }

    public void depositCash(double cashToDeposit){

        if(accountChecker.accountActive(getAccountNumber()) && codeChecker.isCodeCorrect(getSecurityCode())){
            fundsChecker.makeDeposit(cashToDeposit);
            System.out.println("TRANSACTION COMPLETED");
            System.out.println();
        }
        else{
            System.out.println("TRANSACTION FAILED");
            System.out.println();
        }
    }

}
