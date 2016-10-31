package ThreadingSimulations.BankTellerSimulation;

import java.util.concurrent.TimeUnit;

/**
 * Created by shalvi on 02/10/16.
 */
public class Teller implements Runnable, Comparable<Teller> {
    private static int counter = 0 ;
    private final int id = counter++;
    private int customersServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;
    public Teller(CustomerLine cq){
        this.customers = cq;
    }

    @Override
    public int compareTo(Teller o) {
        return customersServed < o.customersServed ? -1 : (customersServed == o.customersServed ? 0 : 1);
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this){
                    customersServed++;
                    while(!servingCustomerLine)
                        wait();
                }
            }
        }
        catch (InterruptedException e){
            System.out.println(this +" interrupted");
        }
        System.out.println(this +" terminating");
    }

    public synchronized void doSomethingElse(){
        customersServed = 0 ;
        servingCustomerLine = false;
    }

    public synchronized void serveCustomerLine(){
        servingCustomerLine = true;
        notifyAll();
    }

    public String toString() { return "Teller" + id + " "; }

    public String shortString(){
        return  "T" + id;
    }

}
