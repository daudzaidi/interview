package ThreadingSimulations.BankTellerSimulation;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by shalvi on 02/10/16.
 */
public class CustomerGenerator implements Runnable {
    private CustomerLine customers;
    private static Random rand = new Random(47);

    public CustomerGenerator (CustomerLine cq){
        customers = cq;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        }
        catch (InterruptedException ie){
            System.out.println("CustomerGenerator Interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}
