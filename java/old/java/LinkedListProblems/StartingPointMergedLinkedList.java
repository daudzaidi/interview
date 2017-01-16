package old.java.LinkedListProblems;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;

/**
 * Created by pandita on 8/9/2015.
 */
public class StartingPointMergedLinkedList<T> {

    public Node<T> findStartingPoint(SinglyLinkedListImpl list1, SinglyLinkedListImpl list2){
        Node<T> start = null;
        //calculate lengths of each list
        int len1=list1.getLengthList(list1);
        int len2=list2.getLengthList(list2);
        int max = (len1>len2)?len1:len2;
        int diff = Math.abs(len1-len2);
        Node<T> tmp1 = list1.getHead();
        Node<T> tmp2 = list2.getHead();
        if(len1>len2){
            for(int i=0;i<diff;i++){
                tmp1=tmp1.getNextRef();
            }
        }
        else if(len1<len2){
            for(int i=0;i<diff;i++){
                tmp2=tmp2.getNextRef();
            }
        }
        while(tmp1!=null && tmp2!=null){
            if(tmp1==tmp2){
                start= tmp1;
                break;
            }
            tmp1=tmp1.getNextRef();
            tmp2=tmp2.getNextRef();
        }

        return start;
    }

    public static void main(String a[]) {
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        SinglyLinkedListImpl<Integer> sl2 = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(100);
        sl.add(67);
        Node<Integer> node1=sl.getRefNode(54);
        sl2.add(0);
        sl2.add(1);
        sl2.add(2);
        sl2.add(10);
        sl2.add(50);
        Node<Integer> node2=sl2.getRefNode(50);
        node2.setNextRef(node1);
        System.out.println("Traversing list 1");
        sl.traverse();
        System.out.println("Traversing list 2");
        sl2.traverse();
        StartingPointMergedLinkedList<Integer> merged = new StartingPointMergedLinkedList<Integer>();
        Node<Integer> start = merged.findStartingPoint(sl,sl2);
        System.out.println("Starting Point: "+ start.getValue());
    }
}
