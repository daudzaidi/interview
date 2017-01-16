package InterviewBit;

import DocPractice.Palindrome;
import com.sun.org.apache.regexp.internal.RE;
import old.java.SinglyLinkedList.Node;

import java.util.List;

/**
 * Created by shyamsunderpandita on 06/01/17.
 */
public class PalindromeList {
    public int lPalin(ListNode A) {
        if(A == null){
            return 0;
        }

        if(A.next == null){
            return 1;
        }

        ListNode temp = A ;

        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }

        if(len == 2){
            if(A.val == A.next.val){
                return 1;
            }
            return 0;
        }

        int middleNodeCount = len/2;
        middleNodeCount = middleNodeCount-1;


        temp = A;
        for(int i = 0 ; i <=middleNodeCount; i++){
            temp = temp.next;
        }

        if(len%2!=0){
            temp = temp.next;
        }

        ListNode rev = reverse(A,middleNodeCount,0);

        while(temp!=null && rev!=null){
            if(rev.val != temp.val){
                return 0;
            }

            temp = temp.next;
            rev = rev.next;
        }


        return 1;
    }

    private ListNode reverse(ListNode a, int middleNodeCount, int c) {
        ListNode prev = null;
        ListNode current = a;
        ListNode next = null;

        if(c > middleNodeCount || current==null || current.next==null){
            //cannot reverse
            return null;
        }
        else{
            while(c<=middleNodeCount && current!=null){
                next=current.next;
                current.next = prev;
                prev=current;
                current=next;
                c++;
            }
        }
        return prev;
    }

    public static void main(String... args){

        PalindromeList l = new PalindromeList();
        ListNode A = new ListNode(4);
        A.next = new ListNode(28);
        A.next.next = new ListNode(6);
        A.next.next.next = new ListNode(23);
        A.next.next.next.next = new ListNode(46);
        A.next.next.next.next.next = new ListNode(46);
        A.next.next.next.next.next.next = new ListNode(23);
        A.next.next.next.next.next.next.next = new ListNode(6);
        A.next.next.next.next.next.next.next.next = new ListNode(28);
        A.next.next.next.next.next.next.next.next.next = new ListNode(4);

        System.out.println(l.lPalin(A));
    }
}


  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
