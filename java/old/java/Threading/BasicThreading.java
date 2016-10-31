package old.java.Threading;

/**
 * Created by pandita on 8/26/2015.
 */
public class BasicThreading implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public BasicThreading(){}


    public String status(){
        return "#"+id+ "("+ (countDown>0?countDown:"Liftoff! )");
    }

    @Override
    public void run() {
    while (countDown-- >0){
        System.out.println(status());
        Thread.yield();
    }
    }

    public static void main(String args[]){
        BasicThreading threading = new BasicThreading();
        Thread t = new Thread(threading);
        t.start();
        System.out.println("WAITING FOR LIFTOFF!!!");
        for(int i =0;i<5;i++){
            new Thread(new BasicThreading()).start();
            System.out.println("WAITING FOR LIFTOFF "+i+"!!!");
        }



    }
}
