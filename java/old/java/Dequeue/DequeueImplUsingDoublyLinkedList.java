package old.java.Dequeue;

import old.java.DoublyLinkedList.Node;

/**
 * Created by pandita on 8/29/2015.
 */
public class DequeueImplUsingDoublyLinkedList<T> {
    private Node<T> front=null;
    private Node<T> rear=null;

    public Node<T> createNewNode(T value){
        Node<T> node = new Node<T>();
        node.setValue(value);
        return node;
    }
    public void addFront(T value){
        Node<T> nd = createNewNode(value);
        if(front==null){
            rear=nd;
        }
        else{
            nd.setNextRef(front);
            front.setPrevRef(nd);
        }
        front=nd;
        System.out.println("Added in Front: "+ value);
    }

    public void addRear(T value){
        Node<T> nd = createNewNode(value);
        if(rear==null){
            front=nd;
        }
        else {
            nd.setPrevRef(rear);
            rear.setNextRef(nd);
        }
        rear=nd;
        System.out.println("Added in Rear: "+ value);
    }

    public void removeFront(){
        if(front==null){
            System.out.println("Underflow.. Cannot delete");
            return;
        }
        Node<T> tmp = front;
        if(tmp.getNextRef()!=null){
            tmp.getNextRef().setPrevRef(null);
            front=tmp.getNextRef();
        }
        else{
            front=null;
            rear=null;
        }
        System.out.println("Deleted from Front: "+ tmp.getValue());
    }

    public void removeRear(){
        if(rear==null){
            System.out.println("Underflow.. Cannot delete");
            return;
        }
        Node<T> tmp = rear;
        if(rear.getPrevRef()==null){
            rear=null;
            front=null;
        }
        else{
            tmp.getPrevRef().setNextRef(null);
            rear=tmp;
        }
        System.out.println("Deleted from Rear: "+ tmp.getValue());
    }

    public static void main(String a[]){

        DequeueImplUsingDoublyLinkedList deq = new DequeueImplUsingDoublyLinkedList();
        deq.addFront(34);
        deq.addRear(45);
        deq.removeFront();
        deq.removeFront();
        deq.removeFront();
        deq.addFront(21);
        deq.addFront(98);
        deq.addRear(5);
        deq.addFront(43);
        deq.removeRear();

    }
}
