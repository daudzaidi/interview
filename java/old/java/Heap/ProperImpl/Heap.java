package old.java.Heap.ProperImpl;
import java.util.Comparator;

/**
 * Created by pandita on 11/17/2015.
 */
public class Heap<T> {

    public static void main(String... args){
        MinHeapImpl<Integer> minheap = new MinHeapImpl<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return lhs-rhs;
            }
        });
        minheap.insertHeap(minheap.createNewHeapNode(10));
        minheap.insertHeap(minheap.createNewHeapNode(20));
        minheap.insertHeap(minheap.createNewHeapNode(1));
        minheap.insertHeap(minheap.createNewHeapNode(12));
        minheap.insertHeap(minheap.createNewHeapNode(-1));
        minheap.insertHeap(minheap.createNewHeapNode(3));

        System.out.println(minheap.getRootNode().getElement());

        minheap.deleteHeap(minheap.heapArr.get(1));

        MaxHeapImpl<Integer> maxheap = new MaxHeapImpl<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return rhs-lhs;
            }
        });
        maxheap.insertHeap(maxheap.createNewHeapNode(10));
        maxheap.insertHeap(maxheap.createNewHeapNode(20));
        maxheap.insertHeap(maxheap.createNewHeapNode(1));
        maxheap.insertHeap(maxheap.createNewHeapNode(12));
        maxheap.insertHeap(maxheap.createNewHeapNode(-1));
        maxheap.insertHeap(maxheap.createNewHeapNode(3));

        System.out.println(maxheap.getRootNode().getElement());

    }
}
