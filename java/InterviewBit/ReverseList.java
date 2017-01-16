package InterviewBit;

/**
 * Created by shyamsunderpandita on 09/01/17.
 */
public class ReverseList {
    public ListNode reverseList(ListNode a) {
        if(a == null || a.next == null){
            return a;
        }

        ListNode curr = a;
        a = reverseList(a.next);
        ListNode temp = a;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = curr;
        curr.next = null;

        return a;
    }

    public void display(ListNode a){
        ListNode temp = a;
        System.out.println();
        while(temp!=null){
            System.out.print(temp.val+"--->");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    public static void main(String... args){
        ListNode A = new ListNode(4);
        A.next = new ListNode(28);
        A.next.next = new ListNode(6);
        A.next.next.next = new ListNode(23);
        A.next.next.next.next = new ListNode(46);

        ReverseList reverseList = new ReverseList();
        reverseList.display(A);
        ListNode B = reverseList.reverseList(A);
        reverseList.display(B);

    }
}
