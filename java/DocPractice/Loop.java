package DocPractice;

/**
 * Created by shalvi on 22/05/16.
 */
//Detect loop in a singly linked list

import Amazon.Set1.Node;

/**
 Assumption:
 I have SinglyLinkedList Class implemented with following operations:
 Add
 Delete
 Search
 Display
 getRefNode
 **/

public class Loop<T>{

    public boolean detectLoop(SinglyLinkedListImpl list){
        Node<T> slowPtr = list.start;
        Node<T> fastPtr = list.start;
        if(slowPtr == null || fastPtr == null)
            return false;

        while(fastPtr!=null){
            fastPtr = fastPtr.getNext();
            if(fastPtr == slowPtr)
                return true;
            if(fastPtr == null)
                break;

            fastPtr = fastPtr.getNext();
            if(slowPtr == fastPtr)
                return true;

            slowPtr = slowPtr.getNext();
        }
     return false;
    }

    public static void main(String [] args){
        SinglyLinkedListImpl<Integer> list = new SinglyLinkedListImpl<>(); // java 8
        for(int i = 0; i< 10 ;i++){
            list.addNode(list.createNewNode(i));
        }
        Node<Integer> node1=list.getRefNode(5);
        Node<Integer> node2=list.getRefNode(8);
        node2.setNext(node1);

        Loop<Integer> loop = new Loop<>();
        if(loop.detectLoop(list)){
            System.out.println("LOOP DETECTED");
        }
        else{
            System.out.println("LOOP NOT DETECTED");
        }


    }
}

