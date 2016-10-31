package old.java.Heap;

import java.util.Comparator;

/**
 * Created by pandita on 9/13/2015.
 */
public class FindMaxinMinHeap {

    public static int findMax(MinBinaryHeap<Integer> heap){
        if(heap==null){
            return 0;
        }
        int size = heap.getSize();
        int i =1;
        int max=(Integer)heap.getHeap().get(1).getElement();
        while(heap.left(i)<=size && heap.right(i)<=size){
            if((Integer)heap.getHeap().get(heap.left(i)).getElement() > max)
                max = (Integer)heap.getHeap().get(heap.left(i)).getElement();

            if((Integer)heap.getHeap().get(heap.right(i)).getElement()>max)
                max=(Integer)heap.getHeap().get(heap.right(i)).getElement();
            i++;
        }
        return max;
    }

    public static void main(String args[]){
        MinBinaryHeap<Integer> heap = new MinBinaryHeap<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        heap.insert(10);
        heap.insert(20);
        heap.insert(1);
        heap.insert(12);
        heap.insert(100);
        heap.insert(-3);

        int max = findMax(heap);

    }
}
