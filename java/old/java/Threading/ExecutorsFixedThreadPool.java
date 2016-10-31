package old.java.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pandita on 9/7/2015.
 */
public class ExecutorsFixedThreadPool {
    public  static void main(String args[]){
        long startTime = System.currentTimeMillis();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i =2;i<1000;i++){
            exec.execute(new Fibonacii(i));
            System.out.println("Printing next Section !!!");
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken :"+totalTime);
        exec.shutdown();
    }
}
