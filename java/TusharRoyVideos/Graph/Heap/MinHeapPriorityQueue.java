package TusharRoyVideos.Graph.Heap;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by shalvi on 09/10/16.
 */
public class MinHeapPriorityQueue {

    PriorityBlockingQueue<Integer> minHeap = new PriorityBlockingQueue<Integer>();

    public void insert(int data){
        minHeap.add(data);
    }

    public void delete(int data){
        minHeap.remove(data);
    }

    public int getMin(){
        return minHeap.poll();
    }

}
