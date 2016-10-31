package DocPractice;

/**
 * Created by pandita on 8/31/2015.
 */
public class node<T> implements Comparable<T> {

    private T value;
    private int key;
    private node<T> left;


    public node<T> getRight() {
        return right;
    }

    public void setRight(node<T> right) {
        this.right = right;
    }

    public node<T> getLeft() {
        return left;
    }

    public void setLeft(node<T> left) {
        this.left = left;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    private node<T> right;

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
