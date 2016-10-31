package old.java.Threading;

import java.util.concurrent.TimeUnit;

/**
 * Created by pandita on 9/7/2015.
 */
public class DaemonThread implements Runnable{


    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+ "" + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        for(int i =0 ; i<10;i++){
            Thread daemon = new Thread(new DaemonThread());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All Daemons Started");
        try {
            TimeUnit.MILLISECONDS.sleep(70);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
