package ThreadingSimulations.BankTellerSimulation;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by shalvi on 02/10/16.
 */
public class CustomerLine extends ArrayBlockingQueue<Customer> {

    public CustomerLine(int maxLineSize) {
        super(maxLineSize);
    }

    public String toString(){
        if(this.size() == 0)
            return "[Empty]";
        StringBuilder builder = new StringBuilder();
        for(Customer customer : this){
            builder.append(customer);
        }
        return builder.toString();
    }
}
