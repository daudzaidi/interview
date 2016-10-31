package old.java.LinkedListProblems;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;

/**
 * Created by pandita on 8/9/2015.
 */
public class ReverseKNodesLinkedList<T> {

    public Node<T> reverseKNodes(Node<T> start, int k){

        if(start==null || start.getNextRef()==null){
            return start;
        }

        Node<T> p1 = start;
        Node<T> p2 = p1.getNextRef();
        Node<T> p3 = p2.getNextRef();
        int cnt =0;
        p1.setNextRef(null);
        cnt++;
        p2.setNextRef(p1);
        cnt++;
        while((cnt<k) && p3!=null){
            cnt++;
            p1=p2;
            p2=p3;
            p3=p3.getNextRef();
            p2.setNextRef(p1);
        }

        start.setNextRef(reverseKNodes(p3,k));
        start = p2;
        return start;
    }

    public static void main(String a[]){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(33);
        sl.add(324);
        sl.add(50);
        sl.add(80);
        sl.add(36);
        sl.add(70);
        sl.add(100);
        sl.add(10);
        ReverseKNodesLinkedList list = new ReverseKNodesLinkedList();
        Node<Integer> start = sl.getHead();
        Node<Integer> result = list.reverseKNodes(start,3);
        Node<Integer> tmp = result;
        while(tmp!=null){
            System.out.println(tmp.getValue());
            tmp=tmp.getNextRef();
        }
    }
}
