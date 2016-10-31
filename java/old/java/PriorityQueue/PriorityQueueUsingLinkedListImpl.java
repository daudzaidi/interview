package old.java.PriorityQueue;

/**
 * Created by pandita on 8/29/2015.
 */
public class PriorityQueueUsingLinkedListImpl<T> {

    private Node<T> head;

    public Node<T> createNewNode(T value,int priority){
        Node<T> nd = new Node<T>();
        nd.setValue(value);
        nd.setPriority(priority);
        return nd;
    }

    //insert highest priority in front and if two nodes with same priority then add in sequential order
    // priority - 1 highest
    public void insertItem(T value,int priority){
        Node<T> nd = createNewNode(value,priority);
        if(head==null){
            head=nd;
        }
        else if(head.getNextRef()==null && head.getPriority()>priority){
            nd.setNextRef(head);
            head=nd;
        }
        else{
            Node<T> ref = getReferencePosNode(priority);
            nd.setNextRef(ref.getNextRef());
            ref.setNextRef(nd);
        }

    }

    public Node<T> getReferencePosNode(int priority){
        Node<T> tmp = head;
        while(tmp.getNextRef()!=null && tmp.getPriority() <= priority && tmp.getNextRef().getPriority() <=priority){
            tmp=tmp.getNextRef();
        }
        return tmp;
    }
    public void deleteHighestPriority(){
    head=head.getNextRef();
    }

    public Node<T> getHighestPriority(){
    return head;
    }

    public static void main(String args[]){
        PriorityQueueUsingLinkedListImpl queue = new PriorityQueueUsingLinkedListImpl();
        queue.insertItem(1,5);
        queue.insertItem(10,1);
        queue.insertItem(100,3);
        queue.insertItem(1000,2);
        queue.insertItem(500,10);
        queue.insertItem(501,8);
        queue.insertItem(600,8);
        queue.insertItem(2,1);

        System.out.println("Highest Priority Element is : "+ queue.getHighestPriority().getValue());
    }
}
