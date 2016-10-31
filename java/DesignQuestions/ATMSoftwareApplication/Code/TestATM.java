package DesignQuestions.ATMSoftwareApplication.Code;

/**
 * Created by shalvi on 18/04/16.
 */
public class TestATM {

    public static void main(String... args){

        Account account = new Account(10,"Shalvi Pandita","C",10000.00,1234);

        Card customersATMCard = new Card(account.getPIN(),account.getStripNumber());

        Customer customer = new Customer(customersATMCard);

        BankComputer bankComputer = new BankComputer("HDFC Bank");

        bankComputer.addAcctToBank(account);

        BankNetwork bankNetwork = new BankNetwork();

        bankNetwork.addBankToNetwork(bankComputer);

        ATM mainStreetATM = new ATM(bankNetwork);

        mainStreetATM.isStripReadable(customersATMCard);

        mainStreetATM.isATMCardsBankInNetwork(customersATMCard);

        mainStreetATM.insertPIN(customersATMCard,1234);

        mainStreetATM.pickAcctToAccess();

        mainStreetATM.amountToWithdrawal();

        mainStreetATM.getTransactionInfo();
    }
}
