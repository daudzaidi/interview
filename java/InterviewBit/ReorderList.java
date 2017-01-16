package InterviewBit;

import java.util.List;

/**
 * Created by shyamsunderpandita on 06/01/17.
 */
public class ReorderList {
    public ListNode reorderList(ListNode a) {
        if(a == null || a.next == null){
            return a;
        }
        int count = getCount(a);
        if(count == 2){
            return a;
        }
        ListNode middle = getMiddle(a);

        if(count%2!=0){
            middle = middle.next;
        }
        ListNode s = a;
        while (s.next!=middle){
            s = s.next;
        }
        s.next = reverse(middle);

        middle = getMiddle(a);

        if(count%2!=0){
            middle = middle.next;
        }

        ListNode start = a;

        while(middle!=null){
            ListNode temp = start.next;
            start.next = middle;
            ListNode midTemp = middle.next;
            if(middle.next !=null) {
                middle.next = temp;
            }

            if(middle.next == null && (count%2!=0)){
                middle.next = temp;
                temp.next = null;
                break;
            }
            start = temp;
            middle = midTemp;
        }

        return a;
    }

    private int getCount(ListNode a) {

        int c = 0;
        while (a!=null){
            c++;
            a = a.next;
        }
        return c;
    }

    private ListNode reverse(ListNode a) {

        ListNode prev = null;
        ListNode current = a;
        ListNode next = null;

        if(current==null){
            //cannot reverse
            return null;
        }
        else if(a.next == null){
            return a;
        }
        else{
            while(current!=null){
                next=current.next;
                current.next = prev;
                prev=current;
                current=next;
            }
        }
        return prev;
    }

    private ListNode getMiddle(ListNode a){

        if(a.next == null){
            return a;
        }

        ListNode ptr = a ;
        ListNode ptr2x = a;

        while(ptr2x!=null){
            ptr2x = ptr2x.next;
            if(ptr2x == null){
                break;
            }

            ptr2x = ptr2x.next;
            ptr = ptr.next;
        }

        return ptr;
    }

    public static void main(String... args){
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);

        ReorderList r = new ReorderList();
        //System.out.println(r.reorderList(A));

        ListNode B = new ListNode(1);
        B.next = new ListNode(2);
        B.next.next = new ListNode(3);
        //B.next.next.next = new ListNode(4);


        ReorderList r2 = new ReorderList();
        System.out.println(r2.reorderList(B));
    }
}
