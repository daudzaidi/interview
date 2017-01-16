package InterviewBit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by shyamsunderpandita on 12/01/17.
 */
public class BSTIterator {

    //Commented solution is also correct but it is less efficient in terms of space complexity
    /*
    TreeNode root;
    static int count = 0;
    ArrayList<Integer> bstSorted = new ArrayList<>();
*/
   /* public BSTIterator(TreeNode node) {
        root = node;
        inorder(root);
    }

    *//** @return whether we have a next smallest number *//*
    public boolean hasNext() {
        return (count >= bstSorted.size()) ? false : true;
    }

    *//** @return the next smallest number *//*
    public int next() {
        int t = count;
        count++;
        return bstSorted.get(t);
    }

    public void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);
        bstSorted.add(node.val);
        inorder(node.right);
    }*/


    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }

    public static void main(String... args){
        TreeNode node = new TreeNode(1000000000);/*
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);*/

        BSTIterator itr = new BSTIterator(node);
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
