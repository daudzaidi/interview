package JavaAlgorithms.PhilospherDiningProblem.Version1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shalvi on 22/06/16.
 */
public class DeadlockInPhiloshperDining {

    public static void main(String... args){
        int ponder = 0;
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }

        for (int i = 0; i < size; i++) {
/*            if(i==0){
                exec.execute(new Philosphers(sticks[(i + 1) % size],
                        sticks[i], i, ponder));
            }
            else{
                exec.execute(new Philosphers(
                        sticks[i], sticks[(i + 1) % size], i, ponder));
            }*/ // This way deadlock avoided but all philospher's not given fair chance

            // This way all philosphers given fair chance
            if(i%2 == 0){
                exec.execute(new Philosphers(sticks[(i + 1) % size],
                        sticks[i], i, ponder));
            }
            else{
                exec.execute(new Philosphers(
                        sticks[i], sticks[(i + 1) % size], i, ponder));
            }

        }

        exec.shutdown();
    }
}
