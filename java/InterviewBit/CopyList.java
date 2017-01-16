package InterviewBit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shyamsunderpandita on 07/01/17.
 */
public class CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null || head.next == null)
            return head;

        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();

        RandomListNode temp = head;

        RandomListNode result = null;

        while(temp!=null){
            result = new RandomListNode(temp.label);
            map.put(temp,result);
            temp = temp.next;

        }

        temp = head;

        while(temp!=null){
            result = map.get(temp);
            result.next = map.get(temp.next);
            result.random = map.get(temp.random);
            temp = temp.next;
        }

        return result;
    }


    private HashMap<RandomListNode, RandomListNode> hashMap;

    public RandomListNode copyRandomList2(RandomListNode head) {

        RandomListNode node, newHead, newNode;
        hashMap = new HashMap<>();

        node = head;
        newHead = null;

        while (node != null) {

            newNode = new RandomListNode(node.label);

            if (newHead == null)
                newHead = newNode;

            hashMap.put(node, newNode);

            node = node.next;

        }

        for (Map.Entry<RandomListNode, RandomListNode> entry : hashMap.entrySet()) {

            node = entry.getKey();
            newNode = entry.getValue();

            if (node.next != null) {
                newNode.next = hashMap.get(node.next);
            }

            if (node.random != null) {
                newNode.random = hashMap.get(node.random);
            }

        }


        return newHead;

    }

    public static void main(String... args){

    }

}

class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
}
