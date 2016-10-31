package old.java.LinkedListProblems;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;

/**
 * Created by pandita on 8/5/2015.
 */
public class ReverseSinglyLinkedList<T> {

    public void IterativeReverse(SinglyLinkedListImpl<T> list){

        Node<T> prev = null;
        Node<T> current = list.getHead();
        Node<T> next = null;

        if(current==null || current.getNextRef()==null){
            //cannot reverse
            return;
        }
        else{
            while(current!=null){
                next=current.getNextRef();
                current.setNextRef(prev);
                prev=current;
                current=next;
            }
            list.setHead(prev);
        }
    }

    public void RecursiveReverse(SinglyLinkedListImpl<T> list){

        Node<T> head = list.getHead();
        if(head==null){
            return;
        }

        if(head.getNextRef()==null){
            list.setHead(head);
            return;
        }

        Node<T> current = head;
        Node<T> next = head.getNextRef();
        list.setHead(head.getNextRef());
        RecursiveReverse(list);
        next.setNextRef(current);
        current.setNextRef(null);
    }

    public static void main(String args[]){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.traverse();
        System.out.println("Iterative - Reversing Linked List ");
        ReverseSinglyLinkedList<Integer> reverse = new ReverseSinglyLinkedList<Integer>();
        reverse.IterativeReverse(sl);
        sl.traverse();
        System.out.println("Recursive - Reversing Linked List ");
        reverse.RecursiveReverse(sl);
        sl.traverse();
    }
}
