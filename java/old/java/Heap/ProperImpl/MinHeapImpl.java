package old.java.Heap.ProperImpl;

import old.java.Heap.Node;

import java.util.ArrayList;
import java.util.Comparator;
/**
 * Created by pandita on 11/17/2015.
 */
public class MinHeapImpl<T> extends HeapOperationsImpl<T>{
    private int position=0;
    ArrayList<Node<T>> heapArr = new ArrayList<Node<T>>();
    final private Comparator<T> comparator;

    public MinHeapImpl(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void insertHeap(Node<T> node) {
        heapArr.add(node);
        node.setPosition(position);
        node.setSize(1);
        int k = position;
        position++;
        if(heapArr.size()>1){
            bubbleUp(node);
        }
        // increment size till the parent
        while(k!=0){
            int pos=heapArr.get(parent(k)).getSize();
            heapArr.get(parent(k)).setSize(pos+1);
            k=parent(k);
        }

    }

    @Override // deleted top element
    public void deleteHeap(Node<T> node) {
        int posDel= node.getPosition();
        for(int i =posDel+1;i<heapArr.size();i++){
            heapArr.get(i).setPosition(i-1);
        }
        heapArr.remove(posDel);
        bubbleDown(heapArr.get(posDel));
        int k = posDel;
        while(k!=0){
            int pos=heapArr.get(parent(k)).getSize();
            heapArr.get(parent(k)).setSize(pos-1);
            k=parent(k);
        }
    }

    @Override
    public void bubbleUp(Node<T> root) {
        int index=root.getPosition();
        while(index>=1 && comparator.compare((T)heapArr.get(parent(index)).getElement(),(T)heapArr.get(index).getElement()) >=0){
            exchange(index,parent(index));
            index=parent(index);
        }
    }

    private void exchange( final int index, final int index2 ) {
        Node temp = heapArr.get(index);
        int size1=temp.getSize();
        int size2=heapArr.get(index2).getSize();
        temp.setPosition(index2);

        Node temp2 = heapArr.get(index2);
        temp2.setPosition(index);


        heapArr.set(index, temp2 );
        heapArr.set( index2, temp);
        heapArr.get(index).setSize(size1);
        heapArr.get(index2).setSize(size2);
    }

    @Override
    public void bubbleDown(Node<T> root) {
        if(root==null){
            return;
        }
        int smallest;
        int index = root.getPosition();
        int left = left(index);
        int right = right(index);

        //  if (left<size && (heap[left]).compareTo(heap[index]) <= 0 )
        if (left<=heapArr.size() && comparator.compare((T)heapArr.get(left).getElement(), (T)heapArr.get(index).getElement()) <= 0 )
            smallest= left;
        else
            smallest = index;

        //    if (right<size && (heap[right]).compareTo(heap[smallest]) <=0 )
        if (right<=heapArr.size() && comparator.compare((T)heapArr.get(right).getElement(),(T) heapArr.get(smallest).getElement() ) <=0 )
            smallest= right;
        if (smallest!= index) {
            exchange( index, smallest );
            bubbleDown( heapArr.get(smallest) );
        }
    }

    @Override
    public Node<T> getRootNode() {
        return heapArr.get(0);
    }


}

