package InterviewBit;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shyamsunderpandita on 13/01/17.
 *
 * NEED TO UNDERSTAND AGAIN !!
 */
public class populateNextRightpointers {
    public void connect(TreeLinkNode root) {

        Queue<TreeLinkNode> queue1 = new LinkedList<>();
        Queue<TreeLinkNode> queue2 = new LinkedList<>();

        if (root == null)
            return;

        queue1.add(root);
        TreeLinkNode node, prev = null;

        while (!queue1.isEmpty() || !queue2.isEmpty()) {

            prev = null;
            while (!queue1.isEmpty()) {
                node = queue1.remove();


                if (prev != null)
                    prev.next = node;

                prev = node;

                if (node.left != null)
                    queue2.add(node.left);


                if (node.right != null)
                    queue2.add(node.right);

            }

            prev = null;
            while (!queue2.isEmpty()) {
                node = queue2.remove();

                if (prev != null)
                    prev.next = node;

                prev = node;

                if (node.left != null)
                    queue1.add(node.left);

                if (node.right != null)
                    queue1.add(node.right);
            }

        }

    }

}

class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
}