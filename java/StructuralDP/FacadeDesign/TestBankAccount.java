package StructuralDP.FacadeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class TestBankAccount {

    public static void main(String... args){

        BankAccountFacade accessingBank = new BankAccountFacade(12345678,1234);

        accessingBank.withdrawCash(50.00);
        accessingBank.withdrawCash(950.00);
        accessingBank.depositCash(200.00);

        accessingBank.withdrawCash(950.00);
    }
}
