package old.java.SinglyLinkedList;

/**
 * Created by pandita on 8/4/2015.
 */
public class Node<T> implements Comparable<T> {
    private T value;
    private Node<T> nextRef;

    @Override
    public int compareTo(T o) {
        if(o==this.value)
            return 0;
        else
            return 1;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNextRef() {
        return nextRef;
    }

    public void setNextRef(Node<T> ptrDiff) {
        this.nextRef = ptrDiff;
    }

    public void setValue(T value) {
        this.value = value;
    }

}