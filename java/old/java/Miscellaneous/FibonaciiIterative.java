package old.java.Miscellaneous;

/**
 * Created by pandita on 8/27/2015.
 */
public class FibonaciiIterative {

    public static void FibIteravtiveImpl(int n){
        int i =0;
        int n1 = 0;
        int n2 = 1;
        while(i<=n){
            if(i==0){
                System.out.println(n1);
            }
            else if(i==1){
                System.out.println(n1+n2);
            }
            else{
                int fib = n1+n2;
                System.out.println(fib);
                n1=n2;
                n2=fib;
            }

            i++;
        }
    }

    public  static void main(String args[]){

        long startTime = System.currentTimeMillis();
        for (int i =2;i<18;i++){
            FibIteravtiveImpl(i);
            System.out.println("Printing next Section !!!");
        }
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time taken :"+totalTime);
    }
}
