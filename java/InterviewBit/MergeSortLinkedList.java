package InterviewBit;

import old.java.Sorting.MergeSort;

/**
 * Created by shyamsunderpandita on 06/01/17.
 */
public class MergeSortLinkedList {
    public ListNode sortList(ListNode A) {

        if (A == null || A.next == null)
            return A;

        ListNode first = A;
        ListNode second = findMidNode(A);

        first = sortList(first);
        second = sortList(second);

        ListNode res = mergeNodes(first, second);

        return res;

    }

    public ListNode mergeNodes(ListNode node1, ListNode node2) {

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                dummy.next = node1;
                node1 = node1.next;
            } else {
                dummy.next = node2;
                node2 = node2.next;
            }
            dummy = dummy.next;
        }

        dummy = addNodes(dummy, node1);
        addNodes(dummy, node2);

        head = head.next;

        return head;
    }

    public ListNode addNodes(ListNode node, ListNode node1) {
        while (node1 != null) {
            node.next = node1;
            node1 = node1.next;
            node = node.next;
        }

        return node;
    }

    public ListNode findMidNode(ListNode node) {

        ListNode doubleRate;
        ListNode prev;

        if (node == null || node.next == null)
            return node;

        doubleRate = node;
        prev = node;

        while (doubleRate.next != null && doubleRate.next.next != null) {
            prev = node;
            node = node.next;
            doubleRate = doubleRate.next.next;
        }

        prev = node;
        node = node.next;
        prev.next = null;

        return node;

    }

    public static void main(String... args){
        ListNode A = new ListNode(4);
        A.next = new ListNode(1);
        A.next.next = new ListNode(6);
        A.next.next.next = new ListNode(5);
        A.next.next.next.next = new ListNode(3);

        MergeSortLinkedList l = new MergeSortLinkedList();
        ListNode t = l.sortList(A);
        while(t!=null){
            System.out.println(t.val);
            t=t.next;
        }
    }

}
