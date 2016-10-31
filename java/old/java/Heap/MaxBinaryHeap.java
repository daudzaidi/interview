package old.java.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pandita on 9/12/2015.
 */
public class MaxBinaryHeap<T> {
    public void setSize(int size) {
        this.size = size;
    }

    private int size;

    public List<Node> getHeap() {
        return heap;
    }

    final private List<Node> heap;
    final private Comparator<T> comparator;

    public MaxBinaryHeap (Comparator<T> comparator){
        size=0;
        heap=new ArrayList<Node>();
        heap.add(null);
        this.comparator=comparator;
    }

    public Node<T> createNewNode(T value, int pos){
        Node<T> node = new Node<T>();
        node.setElement(value);
        node.setPosition(pos);
        return node;
    }
    public void insert(final T element){
        size++;
        Node<T> node = createNewNode(element,size);
        heap.add(node);
        placeNode(node); // to be implemented
    }

    private void placeNode(Node<T> node) {
        int index=node.getPosition();
        while(index>1 && comparator.compare((T)heap.get(parent(index)).getElement(),(T)heap.get(index).getElement()) >=0){
            exchange(index,parent(index));
            index=parent(index);
        }
    }

    private void exchange( final int index, final int index2 ) {
        Node temp = heap.get(index);
        temp.setPosition(index2);

        Node temp2 = heap.get(index2);
        temp2.setPosition(index);

        heap.set(index, temp2 );
        heap.set( index2, temp);
    }

    public void clear() {
        heap.clear();
        size = 0;
    }

    public final T top(){
        Node<T> nd = heap.get(1);
        return nd.getElement();
    }

    public int getSize() {
        return size;
    }

    private final int parent(final int i) {
        return i/2;
    }

    private final int left(final int i) {
        return 2*i;
    }

    private final int right(final int i) {
        return 2*i+1;
    }

    public void maxHeapify(Node<T> node){
        if(node==null){
            return;
        }
        int largest;
        int index = node.getPosition();
        int left = left(index);
        int right = right(index);

        //  if (left<size && (heap[left]).compareTo(heap[index]) <= 0 )
        if (left<=size && comparator.compare((T)heap.get(left).getElement(), (T)heap.get(index).getElement()) <= 0 )
            largest= left;
        else
            largest = index;

        //    if (right<size && (heap[right]).compareTo(heap[smallest]) <=0 )
        if (right<=size && comparator.compare((T)heap.get(right).getElement(),(T) heap.get(largest).getElement() ) <=0 )
            largest= right;
        if (largest!= index) {
            exchange( index, largest );
            maxHeapify(heap.get(largest));
        }
    }

    public void deleteNode(Node<T> nd){
        int posDel= nd.getPosition();
        for(int i =posDel+1;i<=size;i++){
            heap.get(i).setPosition(i-1);
        }
        heap.remove(posDel);
        size=getSize()-1;
    }

    public static void main (String args[]){
        MaxBinaryHeap<Integer> heap = new MaxBinaryHeap<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        heap.insert(10);
        heap.insert(20);
        heap.insert(1);
        heap.insert(12);
        heap.insert(100);
        heap.insert(-3);

        System.out.println(heap.top());

        heap.maxHeapify(heap.getHeap().get(1));
        System.out.println("Heap Maxify has been called ..."+heap.top());

        heap.deleteNode(heap.getHeap().get(1));
        heap.maxHeapify(heap.getHeap().get(1));
        System.out.println("Heap Maxify has been called ..."+heap.top());

        heap.deleteNode(heap.getHeap().get(1));
        heap.maxHeapify(heap.getHeap().get(1));
        System.out.println("Heap Maxify has been called ..." + heap.top());

        heap.deleteNode(heap.getHeap().get(1));
        heap.maxHeapify(heap.getHeap().get(1));
        System.out.println("Heap Maxify has been called ..."+heap.top());
    }
}
