package old.java.Heap.ProperImpl;
import old.java.Heap.Node;
/**
 * Created by pandita on 11/17/2015.
 */
public abstract class HeapOperationsImpl<T>{

    abstract public void insertHeap(Node<T> node);
    abstract public void deleteHeap(Node<T> node);
    abstract public void bubbleUp(Node<T> root);
    abstract public void bubbleDown(Node<T> root);
    abstract public Node<T> getRootNode();

    public Node<T> createNewHeapNode(T element){
        Node<T> newNode=null;
        newNode=new Node<T>(element,0);
        return newNode;
    }


    public  final int parent(final int i) {
        return (i-1)/2;
    }

    public final int left(final int i) {
        return (2*i)+1;
    }

    public final int right(final int i) {
        return (2*i)+2;
    }
}