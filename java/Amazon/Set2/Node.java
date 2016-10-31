package Amazon.Set2;

/**
 * Created by pandita on 8/31/2015.
 */
public class Node<T> implements Comparable<T> {

    private T value;
    private int key;
    private Node<T> left;

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    private Node<T> right;

    @Override
    public int compareTo(T o) {
        if(o==this.value){
            return 0;
        }
        else{
            return 1;
        }
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
