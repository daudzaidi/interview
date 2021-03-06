package old.java.Threading.SharingResource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pandita on 9/20/2015.
 */
public class EvenCheckerResourceConflict implements Runnable {

    private IntGenerator generator;
    private final int id;

    public EvenCheckerResourceConflict(IntGenerator g, int ident){
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
        }
    }

    public static void test(IntGenerator gp, int count){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<count;i++){
            exec.execute(new EvenCheckerResourceConflict(gp,i));
        }
        exec.shutdown();
    }

    public static void main(String args[]){
        EvenCheckerResourceConflict.test(new EvenGenerator(), 10);
    }
}
