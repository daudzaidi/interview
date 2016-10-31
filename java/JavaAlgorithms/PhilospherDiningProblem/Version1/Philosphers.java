package JavaAlgorithms.PhilospherDiningProblem.Version1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by shalvi on 22/06/16.
 */
public class Philosphers implements Runnable{
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);

    public Philosphers(Chopstick left, Chopstick right, int ident, int ponder){
        this.left = left;
        this.right = right;
        this.id = ident;
        this.ponderFactor = ponder;
    }

    private void pause()throws  InterruptedException{
        if(this.ponderFactor == 0) return;

        TimeUnit.MILLISECONDS.sleep(
                rand.nextInt(ponderFactor * 250));

    }


    @Override
    public void run() {

        try{
            while(!Thread.interrupted()){
                System.out.println(this.id + " " + "thinking");
                pause();
                // Philosopher becomes hungry
                System.out.println(this.id + " " + "grabbing right");
                right.take();
                System.out.println(this.id + " " + "grabbing left");
                left.take();
                System.out.println(this.id + " " + "eating");
                pause();
                right.drop();
                left.drop();
            }
        }
        catch (InterruptedException e){
            System.out.println(this + " " + "exiting via interrupt");
        }

    }
}
