package old.java.Heap;

import java.util.Comparator;

/**
 * Created by pandita on 9/13/2015.
 */
public class MiscellaneousQuestions {

    public static void findKElements(MinBinaryHeap<Integer> heap,int k){
        if(heap==null){
            return;
        }
        int size = heap.getSize();
        int i =1;
        while(heap.left(i)<=size && heap.right(i)<=size){

            if((Integer)heap.getHeap().get(i).getElement() <=k)
                System.out.println(heap.getHeap().get(i).getElement());

            if((Integer)heap.getHeap().get(heap.left(i)).getElement() <= k)
                System.out.println(heap.getHeap().get(heap.left(i)).getElement());

            if((Integer)heap.getHeap().get(heap.right(i)).getElement()<=k)
                System.out.println(heap.getHeap().get(heap.right(i)).getElement());

           i++;

        }
    }

    public static void kSmallestElements(MinBinaryHeap<Integer> heap,int k){
        if(heap==null){
            return;
        }

        for(int i=1;i<=k;i++){
            System.out.println(heap.top());
            heap.deleteNode(heap.getHeap().get(1));
            heap.minHeapify(heap.getHeap().get(1));
        }
    }

    public static void kLargestElements(MaxBinaryHeap<Integer> heap,int k){
        if(heap==null){
            return;
        }

        for(int i=1;i<=k;i++){
            System.out.println(heap.top());
            heap.deleteNode(heap.getHeap().get(1));
            heap.maxHeapify(heap.getHeap().get(1));
        }
    }

    public static void main(String args[]) {
        MinBinaryHeap<Integer> heap = new MinBinaryHeap<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        heap.insert(10);
        heap.insert(20);
        heap.insert(1);
        heap.insert(12);
        heap.insert(100);
        heap.insert(-3);
       
        //findKElements(heap,100);
        kSmallestElements(heap,5);

        System.out.println("MAX HEAP");
        MaxBinaryHeap<Integer> heap2 = new MaxBinaryHeap<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        heap2.insert(10);
        heap2.insert(20);
        heap2.insert(1);
        heap2.insert(12);
        heap2.insert(100);
        heap2.insert(-3);
        kLargestElements(heap2,5);
    }
}
