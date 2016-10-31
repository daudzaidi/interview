package JavaAlgorithms.PhilospherDiningProblem.Version1;

/**
 * Created by shalvi on 22/06/16.
 */
public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while(taken){
            wait();
        }
        taken = true;
    }

    public synchronized void drop(){
        taken = false;
        notifyAll();
    }
}
