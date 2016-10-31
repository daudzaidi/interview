package Amazon.Tagged;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by shyamsunderpandita on 18/10/16.
 */
public class KthSmallesElement {
    static PriorityBlockingQueue<Integer> minheap = new PriorityBlockingQueue<>();

    public static int smallesElement(int k, int[][]a){
        int rows = a.length;
        int cols = a[0].length;
        for(int i = 0 ; i< rows ; i++ ){
            for(int j = 0 ; j< cols ; j++){
                minheap.add(a[i][j]);
            }
        }
        int res = 0;
        for (int i = 0 ; i< k ;i++){
            res = minheap.poll();
        }

        return res;
    }

    public static void main(String... args){
        int mat[][] = { {10, 20, 30, 40},
            {15, 25, 35, 45},
            {25, 29, 37, 48},
            {32, 33, 39, 50},
        };
            System.out.println("Smallest element is = "+KthSmallesElement.smallesElement(7,mat));
    }
}
