package old.java.LinkedListProblems;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;

/**
 * Created by pandita on 8/9/2015.
 */
public class MergeLinkedLists<T> {

    public Node<T> mergeLinkedLists(SinglyLinkedListImpl list1, SinglyLinkedListImpl list2){
        Node<T> result = null;
        if(list1==null || list1.getHead()==null){
            return list2.getHead();
        }
        if(list2==null || list2.getHead()==null){
            return list1.getHead();
        }
        if((Integer)list1.getHead().getValue() <(Integer)list2.getHead().getValue()){
            result=list1.getHead();
            list1.setHead(list1.getHead().getNextRef());
            result.setNextRef(mergeLinkedLists(list1,list2));
        }
        else{
            result=list2.getHead();
            list2.setHead(list2.getHead().getNextRef());
            result.setNextRef(mergeLinkedLists(list1,list2));
        }

        return result;
    }

    public static void main(String args[]){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        SinglyLinkedListImpl<Integer> sl2 = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(100);
        sl.add(67);

        sl2.add(0);
        sl2.add(1);
        sl2.add(2);
        sl2.add(10);
        sl2.add(50);
        MergeLinkedLists<Integer> mergeLL = new MergeLinkedLists<Integer>();
        Node<Integer> result = mergeLL.mergeLinkedLists(sl,sl2);
        Node<Integer> tmp = result;
        while(tmp!=null){
            System.out.println(tmp.getValue());
            tmp=tmp.getNextRef();
        }
    }
}
