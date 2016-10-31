package ThreadingSimulations.BankTellerSimulation;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by shalvi on 02/10/16.
 */
public class TellerManager implements Runnable {
    private ExecutorService exec;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<Teller>();
    private int adjustmentPeriod;

    public TellerManager(ExecutorService exec, CustomerLine customers, int adjustmentPeriod) {
        this.exec = exec;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;

        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }

    public void adjustTellerNumber (){ //control mechanism

        //if line long add another teller
        if(customers.size() / workingTellers.size() > 0){
            if(tellersDoingOtherThings.size() > 0){
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }

            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }
        //if line short remove teller
        if(workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2){
            reassignOneteller();
        }

        if(customers.size() == 0){
            while (workingTellers.size() > 1)
                reassignOneteller();
        }
    }

    //Give teller a different job or a break
    private void reassignOneteller() {
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.offer(teller);
    }


    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                System.out.print(customers + "( ");
                for(Teller teller : workingTellers){
                    System.out.print(teller.shortString()+ " ");
                }
                System.out.println(")");
            }
        }
        catch (InterruptedException e){
            System.out.println(this +" interrupted");
        }
        System.out.println(this +" terminating");
    }

    public String toString(){
        return "TellerManager";
    }
}
