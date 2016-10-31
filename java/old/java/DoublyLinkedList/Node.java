package old.java.DoublyLinkedList;

/**
 * Created by pandita on 8/4/2015.
 */
public class Node<T> implements Comparable<T> {

    private T value;
    private Node<T> nextRef;
    private Node<T> prevRef;

    public void setValue(T value){
        this.value=value;
    }

    public T getValue(){
        return this.value;
    }

    public Node<T> getNextRef() {
        return nextRef;
    }

    public void setNextRef(Node<T> nextRef) {
        this.nextRef = nextRef;
    }

    public Node<T> getPrevRef() {
        return prevRef;
    }

    public void setPrevRef(Node<T> prevRef) {
        this.prevRef = prevRef;
    }

    @Override
    public int compareTo(T o) {
        if(this.value==o){
            return 0;
        }
        else{
            return 1;
        }
    }
}
