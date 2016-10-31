package old.java.Threading;

/**
 * Created by pandita on 8/27/2015.
 */
public class Fibonacii implements Runnable{

    protected int n;
    private static int taskCount =0;

    private final int id = taskCount++;

    public Fibonacii(int value){
        this.n=value;
    }

    @Override
    public void run() {
        int i =0;
        int n1 = 0;
        int n2 = 1;
        while(i<=n){
            if(i==0){
                System.out.println("#" + id + ":" + taskCount + " i= " + i + " "+n1);
            }
            else if(i==1){
                System.out.println("#" + id + ":" + taskCount + " i= " + i + " "+n2);
            }
            else{
                int fib = n1+n2;
                System.out.println("#" + id + ":" + taskCount + " i= " + i + " "+fib);
                n1=n2;
                n2=fib;
            }

            i++;
        }
    }

    public  static void main(String args[]){
        long startTime = System.currentTimeMillis();
        for (int i =2;i<5;i++){
            new Thread(new Fibonacii(i)).start();
            System.out.println("Printing next Section !!!");
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken :"+totalTime);
    }
}
