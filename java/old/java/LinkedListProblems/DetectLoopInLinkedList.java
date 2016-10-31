package old.java.LinkedListProblems;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;

import java.util.HashMap;

/**
 * Created by pandita on 8/8/2015.
 */
public class DetectLoopInLinkedList<T> {

    public Node<T> DetectLoopInLinkedListImpl(SinglyLinkedListImpl list){
        Node<T> fastPtr = list.getHead();
        Node<T> slowPtr = list.getHead();
        boolean loopExists =false;
        if(slowPtr==null){
            return null;
        }

        while(slowPtr!=null && fastPtr!=null){
            fastPtr=fastPtr.getNextRef();
            if(fastPtr==slowPtr){
                loopExists=true;
                break;
                //return slowPtr;
            }
            if(fastPtr==null){
                return null;
            }
            fastPtr=fastPtr.getNextRef();
            if(slowPtr==fastPtr){
                loopExists=true;
                break;
               // return slowPtr;
            }
            slowPtr=slowPtr.getNextRef();
        }

        //calculate length of the loop
        if(loopExists){
            int count =0;
            fastPtr=fastPtr.getNextRef();
            while(slowPtr!=fastPtr){
                //slowPtr=slowPtr.getNextRef();
                fastPtr=fastPtr.getNextRef();
                count++;
            }

            //calculate starting point of loop
            slowPtr=list.getHead();
            fastPtr=list.getHead();
            int n =0;
            while(n<count){
                fastPtr=fastPtr.getNextRef();
                n++;
            }

            Node<T> prev = slowPtr;
            while(slowPtr!=fastPtr.getNextRef()){
                prev= slowPtr;
                slowPtr=slowPtr.getNextRef();
                fastPtr=fastPtr.getNextRef();
            }
            prev.setNextRef(slowPtr.getNextRef());
            fastPtr.setNextRef(null);
            return slowPtr;
        }
        return null;
    }
    public Node<T> DetectLoopUsingHashmapImpl(SinglyLinkedListImpl list){
        if(list.getHead()==null){
            return null;
        }
        HashMap<Integer,T> hm = new HashMap<Integer, T>();
        Node<T> tmp = list.getHead();
        int count =0;
        //traverse list and put them in hashmap while checking if the node has been previously added
        while(tmp!=null){
            if(hm.containsValue(tmp.getValue())){
                return tmp;
            }
            hm.put(count,tmp.getValue());
            count++;
            tmp=tmp.getNextRef();
        }
        return null;
    }

    public static void main(String a[]) {
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(100);
        sl.add(67);
        Node<Integer> node1=sl.getRefNode(32);
        Node<Integer> node2=sl.getRefNode(67);
        node2.setNextRef(node1);
        //sl.traverse();
        DetectLoopInLinkedList<Integer> node = new DetectLoopInLinkedList<Integer>();
        Node<Integer> loop = node.DetectLoopInLinkedListImpl(sl);
        if (loop!=null) {
            System.out.println("Loop Detected in one scan method. Starting Point : "+loop.getValue());
        } else {
            System.out.println("No Loop Detected in one scan method");
        }

        loop = node.DetectLoopUsingHashmapImpl(sl);
        if (loop!=null) {
            System.out.println("Loop Detected in HashMap Method. Starting Point: "+loop.getValue());
        } else {
            System.out.println("No Loop Detected in HashMap Method");
        }

    }
}
