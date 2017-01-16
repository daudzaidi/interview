package old.java.LinkedListProblems;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;

/**
 * Created by shalvi on 8/6/2015.
 */
public class GetNthNodeFromEnd<T> {
    //One Scan Approach :
    public Node<T> getNthNodeFromEnd(SinglyLinkedListImpl<T> list, int n){
        Node<T>NthNode = list.getHead();
        Node<T>tmp = list.getHead();
        int count =0;
        if(tmp==null){
            return null;
        }

        while(tmp!=null){
            if(count<n){
                tmp=tmp.getNextRef();
            }
            else{
                tmp=tmp.getNextRef();
                NthNode=NthNode.getNextRef();
            }
            count++;
        }

        if(count >= n-1){
            return NthNode;
        }
        return null;
    }

    public static void main(String a[]){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(67);
        sl.traverse();
        GetNthNodeFromEnd<Integer> node = new GetNthNodeFromEnd<Integer>();
        int n = 3;
        Node<Integer> NthNode = node.getNthNodeFromEnd(sl, n);
        if(NthNode!=null){
        System.out.println(n+ " Node from the end is : "+NthNode.getValue());}
        else {
            System.out.println("Length of list greater than n");
        }
    }
}
