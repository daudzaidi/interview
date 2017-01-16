package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 12/01/17.
 */
public class KthElementInBST {
    ArrayList<Integer> result = new ArrayList<>();
    public int kthsmallest(TreeNode root, int k) {
        kthsmallest(root);
        return result.get(k-1);
    }

    public void kthsmallest(TreeNode root) {
        if(root == null){
            return;
        }
        kthsmallest(root.left);
        result.add(root.val);
        kthsmallest(root.right);
    }

    public static void main(String... args){
        TreeNode node = new TreeNode(12);
        node.left = new TreeNode(10);
        node.right = new TreeNode(30);
        node.right.left= new TreeNode(25);
        node.right.right = new TreeNode(40);
        KthElementInBST p = new KthElementInBST();
        System.out.println(p.kthsmallest(node,2));
    }
}
