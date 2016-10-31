package Amazon.Tagged;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shyamsunderpandita on 18/10/16.
 */
public class CloneBinaryTreeRandomPointer {

    static Map<Node,Node> map = new HashMap<>();
    public static int cloneTree(Node tree){
        if(tree == null)
            return 0;

        Node cloned = cloneLeftRight(tree);
        cloneRandom(tree,cloned);

        return 1;
    }

    private static boolean cloneRandom(Node tree, Node clone) {
        if(clone == null)
            return false;
        clone.random = map.get(tree).random;
        cloneRandom(tree.left,clone.left);
        cloneRandom(tree.right,clone.right);
        return true;
    }

    private static Node cloneLeftRight(Node tree) {
        if(tree == null)
            return null;
        Node clone = new Node(tree.key);
        clone.random = tree.random;
        map.put(tree,clone);
        clone.left = cloneLeftRight(tree.left);
        clone.right = cloneLeftRight(tree.right);
        return clone;
    }

    public static void main(String... args){
        Node tree = new Node(6);
        tree.left = new Node(3);
        tree.right = new Node(8);
        tree.left.left = new Node(1);
        tree.left.left.random = tree.left;
        tree.left.right = new Node(5);
        tree.left.right.random = tree;
        tree.right=new Node(8);

        CloneBinaryTreeRandomPointer.cloneTree(tree);
    }
}

class Node{
    int key;
    Node left, right,random;

    public Node(int k){
        this.key = k;
        left = right = random = null;
    }
}
