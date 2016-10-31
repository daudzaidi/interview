package StructuralDP.FacadeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class AccountNumberCheck {

    private int accountNumber = 12345678;

    public int getAccountNumber(){
        return accountNumber;
    }

    public boolean accountActive(int accountNumber){ // behind the scenes check
        if(accountNumber == this.accountNumber)
            return true;

        return false;
    }
}
