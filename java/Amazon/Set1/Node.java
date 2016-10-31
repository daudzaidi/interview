package Amazon.Set1;

/**
 * Created by shalvi on 28/06/16.
 */


/**
 Making Node Class
 **/

public class Node<T> implements Comparable<T> {
    T data;
    Node<T> next;

    //constructor
    public Node (T value){
        this.data = value;
    }

    //getter and setter
    public T getData(){
        return this.data;
    }

    public void setData(T n){
        this.data = n;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext( Node<T> node){
        this.next = node;
    }

    public int compareTo(T value){
        if(value == this.data)
            return 0;
        else
            return 1;
    }

}
