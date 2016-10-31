package old.java.Threading;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by pandita on 9/7/2015.
 */
public class TaskWithResultCallable implements Callable<String>
{
    private int id;
    public TaskWithResultCallable(int id){
        this.id=id;
    }

    @Override
    public String call() throws Exception {
        return "Result :"+id;
    }

    public static void main(String args[]){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for(int i =0;i<10;i++){
            results.add(exec.submit(new TaskWithResultCallable(i)));
          /*  try {
                System.out.println(results.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }*/
        }
        for(Future<String> fs : results){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
