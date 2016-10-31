package old.java.PriorityQueue;

/**
 * Created by pandita on 8/29/2015.
 */
public class Node<T> implements Comparable<T> {

    private T value;
    private int priority;
    private Node<T> nextRef;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Node<T> getNextRef() {
        return nextRef;
    }

    public void setNextRef(Node<T> nextRef) {
        this.nextRef = nextRef;
    }

    @Override
    public int compareTo(T o) {
    return 0;
    }
}
