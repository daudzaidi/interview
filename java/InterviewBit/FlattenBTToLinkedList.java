package InterviewBit;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shyamsunderpandita on 13/01/17.
 */
public class FlattenBTToLinkedList {
    public TreeNode flatten(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        preorder(queue, A);

        if (queue.isEmpty())
            return A;

        TreeNode node = queue.remove();
        TreeNode next;
        A = node;

        while (!queue.isEmpty()) {
            next = queue.remove();
            node.left = null;
            node.right = next;
            next.left = null;
            node = next;
        }

        return A;
    }

    public void preorder(Queue<TreeNode> queue, TreeNode node) {

        if (node == null)
            return;

        queue.add(node);
        preorder(queue, node.left);
        preorder(queue, node.right);

    }

    public static void main(String... args){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);


        node.right.right = new TreeNode(6);

        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);

        FlattenBTToLinkedList r = new FlattenBTToLinkedList();
        r.flatten(node);
        System.out.println(r);
    }
}
