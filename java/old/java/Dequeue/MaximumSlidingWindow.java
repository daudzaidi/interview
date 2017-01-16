package old.java.Dequeue;

/**
 * Created by pandita on 8/29/2015.
 */
public class MaximumSlidingWindow {

    public static void getMaximum(int[] arr, int k){
        int i =0;
        int count = 0;
        DoubleEndedQueueArrayListImpl<Integer> dequeue = new DoubleEndedQueueArrayListImpl<Integer>();
        while(i<arr.length){
            int j =0;
            i = count;
            while(j<k) {
                if (dequeue.isEmpty()) {
                    dequeue.insertFront(arr[i]);
                }
                else if (dequeue.peekFront() < arr[i]) {
                    dequeue.removeFront();
                    dequeue.removeRear();
                    dequeue.insertFront(arr[i]);
                }
                else if (dequeue.size()==1) {
                    dequeue.insertRear(arr[i]);
                }
                else if (dequeue.peekRear()< arr[i] ){
                    dequeue.removeRear();
                    dequeue.insertRear(arr[i]);
                }
                else{
                    dequeue.removeFront();
                    dequeue.insertFront(dequeue.peekRear());
                    dequeue.removeRear();
                    dequeue.insertRear(arr[i]);
                }

                i++;
                j++;
            }
            System.out.println("Maximum value in Window # "+count+" is :"+ dequeue.peekFront());
            count++;
        }
    }

    public static int[] getMaximumEfficient(int A[], int n, int w, int B[]) {
        DoubleEndedQueueArrayListImpl<Integer> Q = new DoubleEndedQueueArrayListImpl<Integer>();
        for (int i = 0; i < w; i++) {
            while (!Q.isEmpty() && A[i] >= A[Q.peekRear()])
                Q.removeRear();
            Q.insertRear(i);
        }
        for (int i = w; i < n; i++) {
            B[i-w] = A[Q.peekFront()];
            while (!Q.isEmpty() && A[i] >= A[Q.peekRear()])
                Q.removeRear();
            while (!Q.isEmpty() && Q.peekFront() <= i-w)
                Q.removeFront();
            Q.insertRear(i);
        }
        B[n-w] = A[Q.peekFront()];
        return B;
    }

    /**
     * Three rules :
     *  1 . We use dequeue structure
     *  2.  We keep useful indices in dequeue such that elements corresponding to indices are arranged in decreasing order
     *      for a window size k
     *  3. first element that is removed from dequeue is the largest element of that sub array
     **/

    public static void getMaximumClean(int[] arr, int k){

        DoubleEndedQueueArrayListImpl<Integer> Q = new DoubleEndedQueueArrayListImpl();

        for(int i = 0 ; i < k ; i++ ){
            if(!Q.isEmpty() && arr[Q.peekRear()] < arr[i]){
                Q.removeRear();
            }
            Q.insertRear(i);
        }

        for(int i = k ; i < arr.length ; i++){
            System.out.println(arr[Q.peekFront()]);
            while(!Q.isEmpty() && arr[Q.peekRear()] < arr[i]){
                Q.removeRear();
            }
            while(!Q.isEmpty() && Q.peekFront() <= i - k){
                Q.removeFront();
            }

            Q.insertRear(i);
        }

        if(!Q.isEmpty()){
            System.out.println(arr[Q.peekFront()]);
        }
    }
    public static void main(String args[]) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        getMaximumClean(arr,3);
        /*int[] B = getMaximumEfficient(arr,arr.length,3,new int[arr.length]);

        for(int i =0;i<B.length;i++){
            System.out.println("B["+i+"] : "+ B[i]);
        }*/
    }
}
