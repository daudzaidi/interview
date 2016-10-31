package Amazon.Tagged;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by shyamsunderpandita on 22/10/16.
 */
public class PreorderToBST {

    public static Node getBST(int[] pre){
        Node root = null;
        Stack<Node> s = new Stack<>();
        root = new Node(pre[0]);
        s.push(root);
        for (int i = 1; i < pre.length; ++i) {
            Node temp = null;

            /* Keep on popping while the next value is greater than
             stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().key) {
                temp = s.pop();
            }

            // Make this greater value as the right child and push it to the stack
            if (temp != null) {
                temp.right = new Node(pre[i]);
                s.push(temp.right);
            }

            // If the next value is less than the stack's top value, make this value
            // as the left child of the stack's top node. Push the new node to stack
            else {
                temp = s.peek();
                temp.left = new Node(pre[i]);
                s.push(temp.left);
            }
        }
        return root;
    }


    static ArrayList<Integer> preorder = new ArrayList<>();
    public static void preorderTraversal (Node root){
        if(root == null)
            return;

        System.out.println(root.key);
        preorder.add(root.key);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static boolean isValidBST(Node root, int[] pre){
        preorderTraversal(root);

        for(int i = 0 ; i<preorder.size() ; i++){
            if(pre[i] != preorder.get(i))
                return false;
        }
        return true;
    }

    static boolean canRepresentBST(int pre[], int n) {
        // Create an empty stack
        Stack<Integer> s = new Stack<Integer>();

        // Initialize current root as minimum possible
        // value
        int root = Integer.MIN_VALUE;

        // Traverse given array
        for (int i = 0; i < n; i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (pre[i] < root) {
                return false;
            }

            // If pre[i] is in right subtree of stack top,
            // Keep removing items smaller than pre[i]
            // and make the last removed item as new
            // root.
            while (!s.empty() && s.peek() < pre[i]) {
                root = s.peek();
                s.pop();
            }

            // At this point either stack is empty or
            // pre[i] is smaller than root, push pre[i]
            s.push(pre[i]);
        }
        return true;
    }

    public static void main(String... args){
        int pre [] = {40,30,35,80,100};
        Node root = PreorderToBST.getBST(pre);
        System.out.println("Is valid BST = "+ isValidBST(root,pre));
        System.out.println("Is valid prorder = "+ canRepresentBST(pre,pre.length));
    }

}
