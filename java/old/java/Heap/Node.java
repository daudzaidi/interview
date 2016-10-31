package old.java.Heap;

/**
 * Created by pandita on 9/12/2015.
 */
public class Node<T> {

    private T element;
    private int position;
    private int size;

    public Node(T element,int size){
        this.element=element;
        this.size=size;
    }

    public Node(){}

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
