package old.java.LinkedListProblems;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;

/**
 * Created by pandita on 8/9/2015.
 */
public class GetMiddleLinkedList<T> {

    public Node<T> GetMiddleOfLinkedList(SinglyLinkedListImpl list){
        Node<T>ptrX = list.getHead();
        Node<T>ptr2X= list.getHead();

        if(ptrX==null){
            return ptrX;
        }
        int i =0;
        while(ptr2X.getNextRef()!=null){
            if(i==0){
              ptr2X=ptr2X.getNextRef();
                i=1;
            }
            if(i==1 && ptr2X.getNextRef()!=null){
                ptr2X=ptr2X.getNextRef();
                ptrX=ptrX.getNextRef();
                i=0;
            }
        }
        return ptrX;
    }
}
