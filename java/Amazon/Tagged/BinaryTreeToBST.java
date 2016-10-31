package Amazon.Tagged;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shyamsunderpandita on 25/10/16.
 */
public class BinaryTreeToBST {

    static List<Integer> arr = new ArrayList<>();
    static int index = 0 ;

    public static Node getsortedInorder(Node root){
        inorder(root);
        Collections.sort(arr);
        Node BSTRoot = inorderToBST(root);
        return BSTRoot;
    }

    public static void inorder(Node root){
        if(root == null)
            return;

        inorder(root.left);
        arr.add(root.key);
        inorder(root.right);
    }

    public static Node inorderToBST(Node root){
        if(root == null)
            return null;
        inorderToBST(root.left);
        root.key = arr.get(index++);
        inorderToBST(root.right);
        return root;
    }

    public static void main(String... args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node BSTRoot = getsortedInorder(root);
        System.out.println("BT TO BST CONVERTED");
    }
}
