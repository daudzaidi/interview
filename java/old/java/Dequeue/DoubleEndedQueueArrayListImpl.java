package old.java.Dequeue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pandita on 8/29/2015.
 */
public class DoubleEndedQueueArrayListImpl<T> {

    private List<T> dequeue = new ArrayList<T>();

    public void insertFront(T value){
        System.out.println("Inserting Element in Front: "+ value);
        dequeue.add(0,value);
    }

    public void insertRear(T value){
        System.out.println("Inserting Element from Rear: "+ value);
        dequeue.add(value); //by default added in the end
    }

    public void removeFront(){
        if(dequeue.isEmpty()) {
            System.out.println("Cannot remove.. Underflow !!");
            return;
        }
        T val=dequeue.remove(0);
        System.out.println("Deleted Element: "+val);
    }

    public void removeRear(){
        if(dequeue.isEmpty()){
            System.out.println("Cannot remove.. Underflow !!");
            return;
        }
        T val=dequeue.remove(dequeue.size()-1);
        System.out.println("Deleted Element: "+val);
    }

    public T peekFront(){
        return dequeue.get(0);
    }

    public T peekRear(){
        return dequeue.get(dequeue.size()-1);
    }

    public boolean isEmpty(){
        return dequeue.isEmpty();
    }

    public int size() {
        return dequeue.size();
    }

    public static void main(String a[]){

        DoubleEndedQueueArrayListImpl deq = new DoubleEndedQueueArrayListImpl();
        deq.insertFront(34);
        deq.insertRear(45);
        deq.removeFront();
        deq.removeFront();
        deq.removeFront();
        deq.insertFront(21);
        deq.insertFront(98);
        deq.insertRear(5);
        deq.insertFront(43);
        deq.removeRear();

    }
}
