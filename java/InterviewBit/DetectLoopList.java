package InterviewBit;

import old.java.SinglyLinkedList.Node;

/**
 * Created by shyamsunderpandita on 06/01/17.
 */
public class DetectLoopList {
    public ListNode detectCycle(ListNode A) {
        ListNode fastPtr = A;
        ListNode slowPtr = A;
        boolean loopExists = false;
        if (slowPtr == null) {
            return null;
        }

        while (slowPtr != null && fastPtr != null) {
            fastPtr = fastPtr.next;
            if (fastPtr == slowPtr) {
                loopExists = true;
                break;
                //return slowPtr;
            }
            if (fastPtr == null) {
                return null;
            }
            fastPtr = fastPtr.next;
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
                // return slowPtr;
            }
            slowPtr = slowPtr.next;
        }

        //calculate length of the loop
        if (loopExists) {
            int count = 0;
            fastPtr = fastPtr.next;
            while (slowPtr != fastPtr) {
                //slowPtr=slowPtr.getNextRef();
                fastPtr = fastPtr.next;
                count++;
            }

            //calculate starting point of loop
            slowPtr = A;
            fastPtr = A;
            int n = 0;
            while (n < count) {
                fastPtr = fastPtr.next;
                n++;
            }

            ListNode prev = slowPtr;
            while (slowPtr != fastPtr.next) {
                prev = slowPtr;
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            prev.next = slowPtr.next;
            fastPtr.next = null;
            return slowPtr;
        }
        else {
            return null;
        }
    }
}

