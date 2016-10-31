package old.java.Threading.SharingResource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pandita on 9/20/2015.
 */
public class SynchronizedEvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;

    public SynchronizedEvenChecker(IntGenerator g, int ident){
        this.generator=g;
        this.id=ident;
    }
    @Override
    public void run() {
        while(!generator.isCancelled()){
            int val=generator.next();
            if(val % 2 !=0){
                System.out.println(val+" is not Even");
                generator.cancel();
            }
            System.out.println(val + " is even");
        }
    }

    public static void test(IntGenerator gp, int count){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<count;i++){
            exec.execute(new SynchronizedEvenChecker(gp,i));
        }
        exec.shutdown();
    }

    public static void main(String args[]){
        SynchronizedEvenChecker.test(new SynchronizedEvenGenerator(), 10);
    }
}
