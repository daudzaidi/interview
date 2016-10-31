package old.java.LinkedListProblems;

import old.java.SinglyLinkedList.Node;
import old.java.SinglyLinkedList.SinglyLinkedListImpl;
import old.java.Stacks.StackImpl;

/**
 * Created by pandita on 8/9/2015.
 */
public class CheckPlaindrome<T> {

    public boolean CheckPalindomeImpl(SinglyLinkedListImpl list){

        if(list==null)
            return false;

        //Get middle of LL
        GetMiddleLinkedList<T> ml = new GetMiddleLinkedList<T>();
        Node<T> middle = ml.GetMiddleOfLinkedList(list);

        //Reverse second half of LL
        Node<T>secondHalf=middle.getNextRef();
        ReverseSinglyLinkedList <T> rev = new ReverseSinglyLinkedList<T>();
        SinglyLinkedListImpl<T> secondList = new SinglyLinkedListImpl<T>();
        secondList.setHead(secondHalf);
        rev.RecursiveReverse(secondList);

        //compare first half and second half
        Node<T> tmp = list.getHead();
        Node<T> tmp2 = secondList.getHead();
        while(tmp!=middle){
            if(!tmp.getValue().equals(tmp2.getValue())){
                return false;
            }
            tmp=tmp.getNextRef();
            tmp2=tmp2.getNextRef();
        }
        rev.RecursiveReverse(secondList);
        secondHalf=secondList.getHead();
        tmp.setNextRef(secondHalf);
        return true;
    }

    public boolean  checkPalindromStackImpl(SinglyLinkedListImpl list){

        if(list==null)
            return false;
        Node<T> tmp = list.getHead();
        int len = list.getLengthList(list);
        StackImpl<T> arr = new StackImpl<T>(len);
        while(tmp!=null){
            arr.push(tmp.getValue());
            tmp=tmp.getNextRef();
        }

        tmp=list.getHead();
        while(!arr.isStackEmpty() ){
            if(!(arr.pop().equals(tmp.getValue()))){
                return false;
            }
            tmp=tmp.getNextRef();
        }
        return true;
    }


    public static void main(String a[]){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(33);
        sl.add(89);
        sl.add(54);
        sl.add(32);
        sl.add(3);
      //  sl.add(70);
       // sl.add(100);
       // sl.add(10);

        CheckPlaindrome<Integer> pal = new CheckPlaindrome<Integer>();
        boolean isPalindrom = pal.CheckPalindomeImpl(sl);
        if(isPalindrom){
            System.out.println("Is Palindrome");
        }
        else{
            System.out.println("Is Not Palindrome");
        }

        isPalindrom = pal.checkPalindromStackImpl(sl);
        if(isPalindrom){
            System.out.println("Is Palindrome");
        }
        else{
            System.out.println("Is Not Palindrome");
        }
    }
}
