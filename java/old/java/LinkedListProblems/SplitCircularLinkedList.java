package old.java.LinkedListProblems;

import old.java.CircularLinkedList.CircularLinkedListImpl;
import old.java.CircularLinkedList.Node;

/**
 * Created by pandita on 8/11/2015.
 */
public class SplitCircularLinkedList<T> {

    public void SplitCircularLinkedListImpl(CircularLinkedListImpl<T> list){
        Node<T> head = list.getHead();
        if (head.getNextRef()==null){
            return;
        }
        Node<T>ptrX = head;
        Node<T>ptr2X = head;
        int i =0;
        while(ptr2X.getNextRef()!=head){
            if(i==0){
                ptr2X=ptr2X.getNextRef();
                i=1;
            }
            if(i==1 && ptr2X.getNextRef()!=head){
                ptr2X=ptr2X.getNextRef();
                ptrX=ptrX.getNextRef();
                i=0;
            }
        }
        Node<T> middleNextPtr = ptrX.getNextRef();
        ptrX.setNextRef(head);
        ptr2X.setNextRef(middleNextPtr);


        // Traversing these Circular LL
        Node<T> tmp1 = middleNextPtr;
        Node<T>tmp2 = head;


        System.out.println("Traversing First Half");
        while(tmp2.getNextRef()!=head){
            System.out.println(tmp2.getValue());
            tmp2=tmp2.getNextRef();
        }
        System.out.println(tmp2.getValue());

        System.out.println("Traversing Second Half");
        while(tmp1.getNextRef()!=middleNextPtr){
            System.out.println(tmp1.getValue());
            tmp1=tmp1.getNextRef();
        }
        System.out.println(tmp1.getValue());
    }

    public static void main(String args[]){
        CircularLinkedListImpl<Integer> list = new CircularLinkedListImpl<Integer>();
        list.addFirst(0);
        list.addLast(1);
        list.addLast(4);
        list.addAfter(2,1);
        list.addAfter(3,2);
        list.addAfter(5,4);
        list.addLast(6);
        SplitCircularLinkedList<Integer> split = new SplitCircularLinkedList<Integer>();
        split.SplitCircularLinkedListImpl(list);
    }
}
