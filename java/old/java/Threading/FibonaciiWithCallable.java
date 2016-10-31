package old.java.Threading;

import java.util.concurrent.*;

/**
 * Created by pandita on 9/7/2015.
 */
public class FibonaciiWithCallable implements Callable<Integer>{
    private int n ;
    public FibonaciiWithCallable(int n){
        this.n=n;
    }
    @Override
    public Integer call() throws Exception {
        int n1=0;
        int n2=1;
        int i =0;
        int sum=0;
        while(i<n){
            if(n==0){
                System.out.println(n1);
                sum=n1;
            }
            if(n==1){
                System.out.println(n2);
                sum=n2;
            }
            int fib=n1+n2;
            System.out.println(fib);
            sum=sum+fib;
            n1=n2;
            n2=fib;
            i++;
        }
        return sum;
    }

    public static void main(String args[]){
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Integer> res = exec.submit(new FibonaciiWithCallable(5));
        try {
            System.out.println("SUM IS : " + res.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
