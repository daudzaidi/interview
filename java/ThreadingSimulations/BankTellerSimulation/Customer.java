package ThreadingSimulations.BankTellerSimulation;

/**
 * Created by shalvi on 01/10/16.
 */
public class Customer {

    private final int serviceTime;

    public Customer(int time){
        serviceTime = time;
    }

    public int getServiceTime() {
        return serviceTime;
    }
    public String toString(){
        return "[" + serviceTime + "]";
    }

}
